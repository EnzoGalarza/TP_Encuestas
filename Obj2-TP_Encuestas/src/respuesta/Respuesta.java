package respuesta;

import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccionSimple;

public abstract class Respuesta {

	protected String textoRespuesta;

	public String getTextoRespuesta() {
		return this.textoRespuesta;
	}

	public Pregunta getSiguientePregunta() {
		return null;
	}
	
}
