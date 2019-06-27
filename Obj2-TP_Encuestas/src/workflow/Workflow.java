package workflow;

import apiladorDePreguntas.ApiladorDePregunta;
import archivo.ArchivoDeRespuestas;
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

	public void siguiente(Respuesta r) {
		if(this.continua()) {
			this.apilador.apilarPregunta(preguntaActual);
			this.preguntaActual = this.preguntaActual.getSiguientePregunta(r);
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
	
}