package encuesta;


import java.time.LocalDate;

import observer.Observado;
import observer.Observador;
import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

public class Encuesta extends Observado{ 

	private Integer cantDeRespuestasEsperada;
	private Workflow protocolo;
	private EncapsuladorDeRespuesta encapsulador;
	private Boolean disponible;
	private Boolean cerrada;
	private LocalDate fechaDeCreacion;
	private EstadoDeEncuesta estado;
	
	public Encuesta(Workflow protocolo, Integer cantDeRespuestasEsperada, LocalDate localDate) {
		this.protocolo = protocolo;
		this.cantDeRespuestasEsperada = cantDeRespuestasEsperada;
		//this.disponible = false;
		//this.cerrada = false;
		this.encapsulador = new EncapsuladorDeRespuesta();
		this.fechaDeCreacion = localDate;
		this.estado = new EstadoDeEncuestaEnEdicion(this);
	}

	public void siguiente(Respuesta r) {
		// Le pide al protocolo que avance a su proxima Pregunta
		this.protocolo.siguiente(r);
	}
	
	public void finalizarEdicion() {
		// Finaliza la edicion por parte del investigador, permitiendo que se responda
		this.estado.finalizarEdicion();
	}
	
	public void cerrarEncuesta() {
		// Cierra la encuesta, impidiendo que se responda
		this.estado.cerrarEncuesta();
	}
	
	public void anterior() {
		// Le pide al workflow que vuelva a su anterior pregunta
		 this.protocolo.anterior();
	}

	public Integer getCantidadDeRespuestasLimite() {
		// Retorna la cantidad Limite de respuestasCompletas
		return this.cantDeRespuestasEsperada;
	}

	public Boolean finalizada() {
		// Retorna si la encuesta esta cerrada (finalizada)
		return this.cerrada;
	}

	public Pregunta getPreguntaActual() {
		// retorna la pregunta actual
		return this.protocolo.getPregunta();
	}
	
	public void responder(Respuesta unaRespuesta) {
		// Responde la pregunta actual si es posibleResponder
		this.estado.responder(unaRespuesta);	
	}

	public void setPregunta(Pregunta pregunta) {
		// Cambia la pregunta del workflow si es Posible
	    this.estado.setPregunta(pregunta);
	}

	@Override
	public void notify(Pregunta p, Respuesta r) {
		// Notifica a sus observadores que se respondio una pregunta con una respuesta
		for(Observador o : this.observadores) {
			o.update(this, p, r);
		}
	}
	
	public void guardarCambios() {
		// Si se respondio a todas las preguntas cambia la sesion de su encapsulador
		// las respuestas y decrementando en 1 las respuestas limites
	    if(this.getPreguntaActual().esUltimaPregunta()) {
	    	this.estado.guardarCambios();
	    }
		
	  
	}

	public Boolean disponible() {
		// retorna si esta disponible para responder
		return this.estado.esDisponible();
	}

	public LocalDate fechaDeCreacion() {
		return fechaDeCreacion;
	}

	public Integer cantidadDeRespuestasCompletas() {
		// Retorna la cantidad de formularios de esta encuesta completos
		return this.encapsulador.cantidadDeFormulariosCompletos();
	}

	public EncapsuladorDeRespuesta encapsulador() {
		return encapsulador;
	}

	public void actualizarCantidadDeRespuestasEsperada() {
		if(this.cantDeRespuestasEsperada > 1) {
			 this.cantDeRespuestasEsperada--;
			}else {
				this.estado.cerrarEncuesta();;
			}
	}

	public void setEstado(EstadoDeEncuesta nuevoEstado) {
		// TODO Auto-generated method stub
		this.estado = nuevoEstado;
		
	}

	public Workflow workflow() {
		// TODO Auto-generated method stub
		return this.protocolo;
	}

	public EstadoDeEncuesta getEstado() {
		// TODO Auto-generated method stub
		return this.estado;
	}
	
}