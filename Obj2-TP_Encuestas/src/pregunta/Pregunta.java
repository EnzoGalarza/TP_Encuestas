package pregunta;

import respuesta.Respuesta;

public abstract class Pregunta {
	
	protected String textoPregunta;
	
	
	public String getTextoPregunta() {
		return this.textoPregunta + "?";
	}


	public Boolean esPreguntaSeleccionSimple() {
		// TODO Auto-generated method stub
		return false;
	}

	//public abstract void responder(Respuesta respuesta);
	
	public abstract Pregunta getSiguientePregunta(Respuesta r);
	
	public abstract Boolean esUltimaPregunta();
	
}
	