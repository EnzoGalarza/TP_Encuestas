package encuesta;

import java.util.HashMap;
import java.util.Map;


import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

public class Encuesta { 

	private Integer cantDeRespuestasLimite;
	private Workflow protocolo;
	private EncapsuladorDeRespuesta encapsulador;
	
	public Encuesta(Workflow protocolo, Integer cantDeRespuestasLimite) {
		this.protocolo = protocolo;
		this.cantDeRespuestasLimite = cantDeRespuestasLimite;
	}

	public void siguiente(Respuesta r) {	
		this.protocolo.siguiente(r);
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
		//Aca tiene que hacer lo que les dije y mostre en el UML
		encapsulador.agregarRespuestaRealizada(unaRespuesta);
	}

	public void agregarPregunta(Pregunta unaPregunta) {
		protocolo.agregarPregunta(unaPregunta);
	}
	
}