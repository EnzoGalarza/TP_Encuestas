package respuesta;

import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccion;
import pregunta.PreguntaDeSeleccionSimple;
import workflow.Workflow;

public class RespuestaCerrada extends Respuesta {

	private PreguntaDeSeleccion preguntaAResponder;
	private Workflow workflow;
	
	public RespuestaCerrada(String textoRespuesta, PreguntaDeSeleccion preguntaAResponder, Workflow workflow) {
		this.textoRespuesta = textoRespuesta;
		this.preguntaAResponder = preguntaAResponder;
		this.workflow = workflow;
	}

	@Override
	public void responder(String respuesta) {
		if(this.preguntaAResponder.comprobarSiEsRespuestaPosible(this)){
			this.textoRespuesta = respuesta;
			this.workflow.siguiente();
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
