package workflow;

import java.util.ArrayList;

import java.util.List;

import pregunta.Pregunta;

public class Workflow {

	private List<Pregunta> preguntas;
	private Integer posicionPreguntaActual;
	private Integer posicionSiguiente;
	
	
	public Workflow() {
		this.posicionPreguntaActual = 0;
		this.preguntas = new ArrayList<Pregunta>();
	}


	public Pregunta getPregunta() {
		return this.preguntas.get(this.posicionPreguntaActual);
	}


	public Integer posicionPreguntaActual() {
		return this.posicionPreguntaActual;
	}


	public void agregarPregunta(Pregunta nuevaPregunta) {
		this.preguntas.add(nuevaPregunta);
	}


	public void siguiente() {
		if(this.continua()) {
			this.posicionPreguntaActual++;
		}
	}

	public Boolean continua() {
		return this.posicionPreguntaActual+1 < this.preguntas.size();
	}

	public void anterior() {
		if(this.posicionPreguntaActual > 0) {
			this.posicionPreguntaActual--;
		}
	}
	
}