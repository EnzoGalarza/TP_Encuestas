package criterioDeBusqueda;

import java.util.List;

import encuesta.Encuesta;
import proyecto.Proyecto;

public abstract class CriterioDeBusqueda {
	
	public abstract List<Encuesta> filtrarPorCriterio(List<Proyecto> proyectos);
	

}
