package workflow;

import java.util.ArrayList;


import java.util.List;

import archivo.ArchivoDeRespuestas;
import pregunta.Pregunta;
import respuesta.Respuesta;

public class Workflow {

	private List<Pregunta> preguntas;
	private Integer posicionPreguntaActual;
	private ArchivoDeRespuestas archivo;
	
	public Workflow(ArchivoDeRespuestas archivo) {
		this.posicionPreguntaActual = 0;
		this.preguntas = new ArrayList<Pregunta>();
		this.archivo = archivo;
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
		//Quedan preguntas por responder.
		return this.posicionPreguntaActual+1 < this.preguntas.size();
	}

	public void anterior() {
		if(this.posicionPreguntaActual > 0) {
			this.posicionPreguntaActual--;
		}
	}
	
	public void responder(Respuesta respuesta) {
		this.archivo.guardar(this.getPregunta(),respuesta);
	}
	
}