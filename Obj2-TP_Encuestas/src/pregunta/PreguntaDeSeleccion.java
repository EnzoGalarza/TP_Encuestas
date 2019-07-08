package pregunta;

import java.util.Collection;

import respuesta.Respuesta;

public abstract class PreguntaDeSeleccion extends Pregunta {

	private Collection<Respuesta> posiblesRespuestas;

	public PreguntaDeSeleccion(Collection<Respuesta> posiblesRespuestas) {
		this.posiblesRespuestas = posiblesRespuestas;
	}

	public Collection<Respuesta> getPosiblesRespuestas(){
		return this.posiblesRespuestas;
	}


}