package respuesta;

import pregunta.Pregunta;
import pregunta.PreguntaAbierta;
import pregunta.PreguntaDeSeleccionSimple;

public class RespuestaLibre extends Respuesta {
	
	public RespuestaLibre(String respuesta) {
		this.textoRespuesta = respuesta;
	}

	public void setTextoRespuesta(String texto) {
		this.textoRespuesta = texto;
	}
}
