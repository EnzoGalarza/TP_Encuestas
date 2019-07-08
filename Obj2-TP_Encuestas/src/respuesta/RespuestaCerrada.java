package respuesta;

import pregunta.Pregunta;

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
