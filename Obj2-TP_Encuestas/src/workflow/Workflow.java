package workflow;

import apiladorDePreguntas.ApiladorDePregunta;
import pregunta.Pregunta;
import respuesta.Respuesta;

public class Workflow {

	private Pregunta preguntaActual;
	private ApiladorDePregunta apilador;
	
	public Workflow(Pregunta preguntaInicial) {
		this.preguntaActual = preguntaInicial;
		this.apilador = new ApiladorDePregunta();
	}


	public Pregunta getPregunta() {
		return this.preguntaActual;
	}

	public void siguiente(Respuesta respuesta) {
		if(this.continua()) {
			this.apilador.apilarPregunta(preguntaActual);
			this.preguntaActual = this.preguntaActual.getSiguientePregunta(respuesta);
		}
	}

	public Boolean continua() {
		//Dice si quedan preguntas por responder.
		return !this.getPregunta().esUltimaPregunta();
	}

	public void anterior() {
		if(this.apilador.tienePreguntas()) {
			this.preguntaActual = this.apilador.obtenerPregunta();
		}
	}
	
	public void setPregunta(Pregunta pregunta) {
		this.preguntaActual = pregunta;
	}
	
	public void vaciarApilador() {
		this.preguntaActual = this.apilador.primerPregunta();
		this.apilador.vaciarApilador();
	}
	
	public Boolean tieneAnterior() {
		return this.apilador.tienePreguntas();
	}
	
}