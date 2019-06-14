package respuesta;

import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccionSimple;
import pregunta.PreguntaNula;

public abstract class Respuesta {

	protected String textoRespuesta;

	public String getTextoRespuesta() {
		return this.textoRespuesta;
	}

	public  Pregunta getSiguientePregunta() {
		Pregunta pregunta = new PreguntaNula();
		return pregunta;
	}
	
}
