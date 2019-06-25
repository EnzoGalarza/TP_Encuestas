package encuesta;


import observer.Observado;
import observer.Observador;
import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

public class Encuesta extends Observado{ 

	private Integer cantDeRespuestasLimite;
	private Workflow protocolo;
	private EncapsuladorDeRespuesta encapsulador;
	private Boolean disponible;
	private Boolean cerrada;
	
	public Encuesta(Workflow protocolo, Integer cantDeRespuestasLimite) {
		this.protocolo = protocolo;
		this.cantDeRespuestasLimite = cantDeRespuestasLimite;
		this.disponible = false;
		this.cerrada = false;
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
		return this.cantDeRespuestasLimite;
	}

	public Boolean finalizada() {
		return this.cantDeRespuestasLimite == 0;
	}

	public Pregunta getPreguntaActual() {
		return this.protocolo.getPregunta();
	}
	
	public void responder(Respuesta unaRespuesta) {
		
	  if(this.disponible && !this.cerrada) {	
		encapsulador.agregarRespuestaRealizada(unaRespuesta);
		this.notify(this.getPreguntaActual(), unaRespuesta);
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
	
}