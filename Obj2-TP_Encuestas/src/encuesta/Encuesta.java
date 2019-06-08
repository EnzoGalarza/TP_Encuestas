package encuesta;

import java.util.HashMap;
import java.util.Map;


import pregunta.Pregunta;
import respuesta.Respuesta;
import workflow.Workflow;

public class Encuesta { 

	private Integer cantDeRespuestasLimite;
	private Workflow protocolo;
	
	public Encuesta(Workflow protocolo, Integer cantDeRespuestasLimite) {
		this.protocolo = protocolo;
		this.cantDeRespuestasLimite = cantDeRespuestasLimite;
	}

	public void siguiente() {	
		this.protocolo.siguiente();
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

	public void agregarPregunta(Pregunta nuevaPregunta) {
		this.protocolo.agregarPregunta(nuevaPregunta);
	}

	public Pregunta getPreguntaActual() {
		return this.protocolo.getPregunta();
	}

	
}