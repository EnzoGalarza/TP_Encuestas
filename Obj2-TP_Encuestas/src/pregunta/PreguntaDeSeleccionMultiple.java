package pregunta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import respuesta.Respuesta;

public class PreguntaDeSeleccionMultiple extends PreguntaDeSeleccion {
	
	//Las respuestas de esta clase deben ser respuestas cerradas
	public PreguntaDeSeleccionMultiple(String textoPregunta, Collection<Respuesta> posiblesRespuestas) {
		super(posiblesRespuestas);
		this.textoPregunta = textoPregunta;
	}

	/*@Override
	public void responder(Respuesta respuesta) {
		//Asumimos que la respuesta es una respuestaCerrada
		
	}*/
	
	
}

