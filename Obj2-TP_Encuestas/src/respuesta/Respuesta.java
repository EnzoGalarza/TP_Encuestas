package respuesta;

import encuesta.Encuesta;
import observer.Observado;
import pregunta.Pregunta;
import pregunta.PreguntaNula;

public abstract class Respuesta extends Observado{

	protected String textoRespuesta;

	public String getTextoRespuesta() {
		return this.textoRespuesta;
	}

	public  Pregunta getSiguientePregunta() {
		Pregunta pregunta = new PreguntaNula();
		return pregunta;
	}
	
	public void notificar(Encuesta e, Pregunta p) {
		this.notify(e, p, this);
	}
}
