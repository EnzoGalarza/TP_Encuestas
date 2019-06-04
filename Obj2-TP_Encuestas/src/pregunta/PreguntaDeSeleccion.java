package pregunta;

import java.util.Collection;
import java.util.List;

import respuesta.Respuesta;

public abstract class PreguntaDeSeleccion extends Pregunta {

	private Collection<Respuesta> posiblesRespuestas;
	protected List<Respuesta> respuestasElegidas;

	public PreguntaDeSeleccion(Collection<Respuesta> posiblesRespuestas) {
		this.posiblesRespuestas = posiblesRespuestas;
	}

	public Collection<Respuesta> getPosiblesRespuestas(){
		return this.posiblesRespuestas;
	}

	public Boolean comprobarSiEsRespuestaPosible(Respuesta respuesta) {
		return (this.posiblesRespuestas.contains(respuesta));
	}


}