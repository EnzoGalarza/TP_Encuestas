package encuesta;


import java.util.function.BooleanSupplier;

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
	
	public Encuesta(Workflow protocolo, Integer cantDeRespuestasEsperada) {
		this.protocolo = protocolo;
		this.cantDeRespuestasEsperada = cantDeRespuestasEsperada;
		this.disponible = false;
		this.cerrada = false;
		this.encapsulador = new EncapsuladorDeRespuesta();
	}

	public void siguiente(Respuesta r) {	
		this.protocolo.siguiente(r);
	}
	
	public void finalizarEdicion() {
		this.disponible = true;
	}
	
	public void cerrarEncuesta() {
		this.cerrada = true;
	}
	
	public void anterior() {
		 this.protocolo.anterior();
	}

	public Integer getCantidadDeRespuestasLimite() {
		return this.cantDeRespuestasEsperada;
	}

	public Boolean finalizada() {
		return this.cerrada;
	}

	public Pregunta getPreguntaActual() {
		return this.protocolo.getPregunta();
	}
	
	public void responder(Respuesta unaRespuesta) {
		
	  if(this.disponible && !this.cerrada) {	
		encapsulador.agregarRespuestaRealizada(this.getPreguntaActual(),unaRespuesta);
		this.notify(this.getPreguntaActual(), unaRespuesta);
		this.siguiente(unaRespuesta);
	  }	
	}
	
	public void setPregunta(Pregunta pregunta) {
	  if(!disponible && !cerrada) {
		this.protocolo.setPregunta(pregunta);
	  }	
	}

	@Override
	public void notify(Pregunta p, Respuesta r) {
		// TODO Auto-generated method stub
		for(Observador o : this.observadores) {
			o.update(this, p, r);
		}
	}
	
	public void guardarCambios() {
	  if(this.cantDeRespuestasEsperada > 0 && this.getPreguntaActual().esUltimaPregunta()) {	
		this.encapsulador.nuevaSesion();
		this.cantDeRespuestasEsperada--;
	  }
	}

	public Boolean disponible() {
		return this.disponible;
	}
	
}