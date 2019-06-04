package pregunta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import respuesta.Respuesta;

public class PreguntaDeSeleccionMultiple extends PreguntaDeSeleccion {
	
	//Las respuestas de esta clase deben ser respuestas cerradas
	public PreguntaDeSeleccionMultiple(String textoPregunta, Collection<Respuesta> posiblesRespuestas, Pregunta siguientePregunta) {
		super(posiblesRespuestas);
		this.textoPregunta = textoPregunta;
		this.respuestasElegidas = new ArrayList<Respuesta>();
		this.siguientePregunta = siguientePregunta;
	}

	@Override
	public void responder(Respuesta respuesta) {
		//Asumimos que la respuesta es una respuestaCerrada
		if(this.comprobarSiEsRespuestaPosible(respuesta)) {
			this.respuestasElegidas.add(respuesta);
		}
	}
	
	public List<Respuesta> getRespuestasElegidas() {
		return this.respuestasElegidas;
	}

	@Override
	public Pregunta getSiguientePregunta() {
		// TODO Auto-generated method stub
		return this.siguientePregunta;
	}

	public Integer cantidadDeRespuestas() {
		// TODO Auto-generated method stub
		return this.respuestasElegidas.size();
	}
}

