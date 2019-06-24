package encuesta;


import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

public class Encuesta { 

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
	  }	
	}
	
	public void setPregunta(Pregunta pregunta) {
	  if(!disponible && !cerrada) {
		this.protocolo.setPregunta(pregunta);
	  }	
	}
	
}