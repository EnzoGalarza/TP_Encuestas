package respuesta;

import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccionSimple;

public abstract class Respuesta {

	protected String textoRespuesta;

	public String getTextoRespuesta() {
		return this.textoRespuesta;
	}

	public abstract void responder(String respuesta);

	public abstract boolean esRespuestaLibre();
	
	public abstract Pregunta getPreguntaRespondida();
	
}
