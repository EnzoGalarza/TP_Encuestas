package pregunta;

import encuesta.Encuesta;
import observer.Observado;
import respuesta.Respuesta;

public abstract class Pregunta extends Observado{
	
	protected String textoPregunta;
	
	
	public String getTextoPregunta() {
		return this.textoPregunta + "?";
	}


	/*public Boolean esPreguntaSeleccionSimple() {
		// TODO Auto-generated method stub
		return false;
	}*/

	//public abstract void responder(Respuesta respuesta);
	
	public abstract Pregunta getSiguientePregunta(Respuesta r);
	
	public  Boolean esUltimaPregunta() {
		return false;
	}
	
	public void notificar(Encuesta e, Respuesta r) {
		this.notify(e, this, r);
	}
	
}
	