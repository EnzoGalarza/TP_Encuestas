package observer;

import encuesta.Encuesta;
import pregunta.Pregunta;
import respuesta.Respuesta;

public interface Observador {

	public void update(Encuesta e, Pregunta p, Respuesta r);
	
	public Boolean esDeInteres(Pregunta p, Respuesta r);
	
}
