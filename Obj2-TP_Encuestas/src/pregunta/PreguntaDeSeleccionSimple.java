package pregunta;

import java.util.Collection;

import respuesta.Respuesta;

public class PreguntaDeSeleccionSimple extends PreguntaDeSeleccion {
	
	//private Pregunta siguientePregunta;
	
	public PreguntaDeSeleccionSimple(String textoPregunta, Collection<Respuesta> posiblesRespuestas) {
		super(posiblesRespuestas);
		this.textoPregunta = textoPregunta;
	}
	
	@Override
	public Pregunta getSiguientePregunta(Respuesta respuesta) {
		// TODO Auto-generated method stub
		return respuesta.getSiguientePregunta();
	}
	
}
