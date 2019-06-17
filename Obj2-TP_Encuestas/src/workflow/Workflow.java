package workflow;

import java.util.ArrayList;
import java.util.List;

import archivo.ArchivoDeRespuestas;
import pregunta.Pregunta;
import respuesta.Respuesta;

public class Workflow {

	private ArchivoDeRespuestas archivo;
	private Pregunta preguntaActual;
	
	public Workflow(ArchivoDeRespuestas archivo,Pregunta preguntaInicial) {
		this.preguntaActual = preguntaInicial;
		this.archivo = archivo;
	}


	public Pregunta getPregunta() {
		return this.preguntaActual;
	}

	public void siguiente(Respuesta r) {
		if(this.continua()) {
			this.preguntaActual = this.preguntaActual.getSiguientePregunta(r);
		}
	}

	public Boolean continua() {
		//Dice si quedan preguntas por responder.
		return true;
	}

	public void anterior() {
		
	}
	
}