package pregunta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import respuesta.Respuesta;

public class PreguntaDeSeleccionMultiple extends PreguntaDeSeleccion {
	
	private Pregunta siguientePregunta;
	
	public PreguntaDeSeleccionMultiple(String textoPregunta, Collection<Respuesta> posiblesRespuestas) {
		super(posiblesRespuestas);
		this.textoPregunta = textoPregunta;
	}

	@Override
	public Pregunta getSiguientePregunta(Respuesta respuesta) {
		// TODO Auto-generated method stub
		return this.siguientePregunta;
	}

	/*@Override
	public void responder(Respuesta respuesta) {
		//Asumimos que la respuesta es una respuestaCerrada
		
	}*/
	
	public void setSiguientePregunta(Pregunta pregunta) {
		this.siguientePregunta = pregunta;
	}

	@Override
	public Boolean esUltimaPregunta() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

