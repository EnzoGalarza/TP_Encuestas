package encuesta;

import java.util.List;

public abstract class CriterioDeBusqueda {
	
	public abstract List<Encuesta> filtrarPorCriterio(List<Encuesta> encuestas);

}
