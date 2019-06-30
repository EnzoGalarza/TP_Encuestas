package criterioDeBusqueda;

import java.util.List;

import encuesta.Encuesta;

public abstract class CriterioDeBusqueda {
	
	public abstract List<Encuesta> filtrarPorCriterio(List<Encuesta> encuestas);

}
