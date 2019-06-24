package pregunta;

import respuesta.Respuesta;
import respuesta.RespuestaLibre;

public class PreguntaAbierta extends Pregunta {
	
	private Pregunta siguientePregunta;
	
	public PreguntaAbierta(String textoPregunta) {
		// Posible cambio en el constructor
		this.textoPregunta = textoPregunta;
	}

	@Override
	public Pregunta getSiguientePregunta(Respuesta respuesta) {
		// TODO Auto-generated method stub
		return this.siguientePregunta;
	}
	
	public void setSiguientePregunta(Pregunta pregunta) {
		this.siguientePregunta = pregunta;
	}

	@Override
	public Boolean esUltimaPregunta() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
