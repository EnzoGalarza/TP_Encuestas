package respuesta;

import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccion;
import pregunta.PreguntaDeSeleccionSimple;
import workflow.Workflow;

public class RespuestaCerrada extends Respuesta {
	
	private Pregunta siguientePregunta;
	
	public RespuestaCerrada(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	public RespuestaCerrada(String string, Pregunta preguntaSiguiente) {
		// TODO Auto-generated constructor stub
		this.textoRespuesta = string;
		this.siguientePregunta = preguntaSiguiente;
	}

	@Override
	public Pregunta getSiguientePregunta() {
		// TODO Auto-generated method stub
		return this.siguientePregunta;
	}

}
