package pregunta;

import java.util.Collection;

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
	
	public void setSiguientePregunta(Pregunta pregunta) {
		this.siguientePregunta = pregunta;
	}
	
}

