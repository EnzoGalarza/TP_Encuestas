package pregunta;

import respuesta.Respuesta;

public abstract class Pregunta {
	
	protected String textoPregunta;
	protected Pregunta siguientePregunta;
	
	public String getTextoPregunta() {
		return this.textoPregunta + "?";
	}

	public abstract void responder(Respuesta respuesta);
	
	public abstract Pregunta getSiguientePregunta();
	
}
	