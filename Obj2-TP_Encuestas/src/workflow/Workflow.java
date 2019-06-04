package workflow;

import java.util.HashMap;
import java.util.Map;

import pregunta.Pregunta;

public class Workflow {

	private Map<Integer,Pregunta> preguntas;
	private Integer posicionPreguntaActual;
	private Pregunta preguntaActual;
	private Integer posicionSiguiente;
	
	
	public Workflow() {
		this.posicionPreguntaActual = 0;
		this.preguntas = new HashMap<Integer,Pregunta>();
		this.posicionSiguiente = 1;
	}


	public Pregunta getPregunta() {
		return this.preguntaActual;
	}


	public Integer posicionPreguntaActual() {
		return this.posicionPreguntaActual;
	}


	public void agregarPregunta(Pregunta nuevaPregunta) {
		this.preguntas.put(posicionSiguiente, nuevaPregunta);
		if(posicionPreguntaActual == 0) {
			this.preguntaActual = nuevaPregunta;
			this.posicionPreguntaActual++;
		}
		this.posicionSiguiente++;
	}


	public void siguiente() {
		if(this.continua()) {
			this.posicionPreguntaActual++;
			this.preguntaActual = this.preguntas.get(posicionPreguntaActual);
		}
	}

	public Boolean continua() {
		return this.preguntas.containsKey(posicionPreguntaActual+1);
	}

	public void anterior() {
		if(this.preguntas.containsKey(posicionPreguntaActual-1)) {
			this.posicionPreguntaActual--;
			this.preguntaActual = this.preguntas.get(posicionPreguntaActual);
		}
	}
	
}