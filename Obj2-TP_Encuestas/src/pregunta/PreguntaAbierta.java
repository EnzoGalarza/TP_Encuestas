package pregunta;

import respuesta.Respuesta;

public class PreguntaAbierta extends Pregunta {
	
	private Pregunta siguientePregunta;
	
	public PreguntaAbierta(String textoPregunta) {
		// Posible cambio en el constructor
		this.textoPregunta = textoPregunta;
	}

	@Override
	public Pregunta getSiguientePregunta(Respuesta respuesta) {
		// retorna su siguiente pregunta
		return this.siguientePregunta;
	}
	
	public void setSiguientePregunta(Pregunta pregunta) {
		// cambia su siguiente pregunta
		this.siguientePregunta = pregunta;
	}
	
}
