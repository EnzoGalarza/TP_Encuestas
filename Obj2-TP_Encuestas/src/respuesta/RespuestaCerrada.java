package respuesta;

import pregunta.PreguntaDeSeleccion;

public class RespuestaCerrada extends Respuesta {

	private PreguntaDeSeleccion preguntaAResponder;
	
	public RespuestaCerrada(String textoRespuesta, PreguntaDeSeleccion preguntaAResponder) {
		this.textoRespuesta = textoRespuesta;
		this.preguntaAResponder = preguntaAResponder;
	}

	@Override
	public void responder(String respuesta) {
		if(this.preguntaAResponder.comprobarSiEsRespuestaPosible(this)){
			this.textoRespuesta = respuesta;
		}
	}

	public PreguntaDeSeleccion getPreguntaRespondida() {
		return this.preguntaAResponder;
	}

	@Override
	public boolean esRespuestaLibre() {
		return false;
	}

}
