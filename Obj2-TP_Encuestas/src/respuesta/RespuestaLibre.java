package respuesta;

import pregunta.Pregunta;
import pregunta.PreguntaAbierta;
import pregunta.PreguntaDeSeleccionSimple;

public class RespuestaLibre extends Respuesta {

	private PreguntaAbierta preguntaAResponder;
	
	public RespuestaLibre(PreguntaAbierta preguntaAResponder) {
		this.textoRespuesta = "";
		this.preguntaAResponder = preguntaAResponder;
	}

	public PreguntaAbierta getPreguntaRespondida() {
		return this.preguntaAResponder;
	}

	@Override
	public void responder(String respuesta) {
		this.textoRespuesta = respuesta;
	}

	@Override
	public boolean esRespuestaLibre() {
		return true;
	}

}
