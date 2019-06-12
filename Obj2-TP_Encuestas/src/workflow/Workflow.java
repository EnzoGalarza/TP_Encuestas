package workflow;

import java.util.ArrayList;
import java.util.List;

import archivo.ArchivoDeRespuestas;
import pregunta.Pregunta;
import respuesta.Respuesta;

public class Workflow {

	private List<Pregunta> preguntas;
	private Integer posicionPreguntaActual;
	private Integer posicionPreguntaAnterior;
	private ArchivoDeRespuestas archivo;
	private Pregunta preguntaActual;
	
	public Workflow(ArchivoDeRespuestas archivo,Pregunta pregunta) {
		this.posicionPreguntaActual = 0;
		this.posicionPreguntaAnterior = -1;
		this.preguntas = new ArrayList<Pregunta>();
		this.preguntas.add(pregunta);
		this.preguntaActual = pregunta;
		this.archivo = archivo;
	}


	public Pregunta getPregunta() {
		return this.preguntaActual;
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
			this.posicionPreguntaAnterior++;
			this.preguntaActual = this.preguntas.get(posicionPreguntaActual);
		}
	}

	public Boolean continua() {
		//Dice si quedan preguntas por responder.
		return this.posicionPreguntaActual+1 < this.preguntas.size();
	}

	public void anterior() {
		if(this.posicionPreguntaAnterior > 0) {
			this.preguntaActual = this.preguntas.get(posicionPreguntaAnterior);
			this.posicionPreguntaActual--;
			this.posicionPreguntaAnterior--;
		}
	}
	
	public void responder(Respuesta respuesta) {
		//Aca cambie esto del responder para la siguiente pregunta... igual hay que preguntar
		// en clase por que seguimos con los problemas de tipo 
		this.archivo.guardar(this.getPregunta(),respuesta);
		if(this.getPregunta().esPreguntaSeleccionSimple()) {
			this.posicionPreguntaAnterior = this.posicionPreguntaActual;
			this.posicionPreguntaActual = this.preguntas.indexOf(respuesta.getSiguientePregunta()); 
		}
	}
	
}