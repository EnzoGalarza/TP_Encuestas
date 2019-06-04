package pregunta;

import respuesta.Respuesta;
import respuesta.RespuestaLibre;

public class PreguntaAbierta extends Pregunta {

	private Respuesta respuestaElegida;

	public PreguntaAbierta(String textoPregunta, Pregunta siguientePregunta) {
		// Posible cambio en el constructor
		this.textoPregunta = textoPregunta;
		this.siguientePregunta = siguientePregunta;
		this.respuestaElegida = new RespuestaLibre(this);
	}

	public Respuesta respuestaElegida() {
		// Se debe asegurar responder a la pregunta antes de invocar.
		return this.respuestaElegida;
	}
	
	@Override
	public void responder(Respuesta respuesta) {
		// Asumimos que la respuesta que nos llega es una respuestaLbre
	  if(respuesta.esRespuestaLibre())	
	    this.respuestaElegida = respuesta;
	}

	public Pregunta getSiguientePregunta() {
		// TODO Auto-generated method stub
		return this.siguientePregunta;
	}
	
}
