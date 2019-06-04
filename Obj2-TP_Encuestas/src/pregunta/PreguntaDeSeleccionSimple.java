package pregunta;

import java.util.ArrayList;
import java.util.Collection;

import respuesta.Respuesta;

public class PreguntaDeSeleccionSimple extends PreguntaDeSeleccion {
	
	public PreguntaDeSeleccionSimple(String textoPregunta, Collection<Respuesta> posiblesRespuestas) {
		super(posiblesRespuestas);
		this.textoPregunta = textoPregunta;
		this.respuestasElegidas = new ArrayList<Respuesta>(); 
	}

	@Override
	public void responder(Respuesta respuesta) {	
	    if(super.comprobarSiEsRespuestaPosible(respuesta)) {	
	      this.marcarRespuesta(respuesta);
	    }   
	}

	private void marcarRespuesta(Respuesta respuesta) {
		if(this.respuestasElegidas.size() == 1) {
			this.respuestasElegidas.clear();
			this.respuestasElegidas.add(respuesta);
		}
		else {
			this.respuestasElegidas.add(respuesta);
		}
	}

	public Respuesta getRespuestaElegida() {
	 	if(!this.respuestasElegidas.isEmpty())
	     return this.respuestasElegidas.get(0);
	 	else
	 		throw new RuntimeException("No completo con una respuesta");
	}

	@Override
	public Pregunta getSiguientePregunta() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
