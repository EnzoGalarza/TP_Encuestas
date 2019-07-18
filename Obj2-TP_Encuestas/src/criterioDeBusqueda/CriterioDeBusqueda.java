package criterioDeBusqueda;

import java.util.List;

import encuesta.Encuesta;
import proyecto.Proyecto;

public interface CriterioDeBusqueda {
	
	public List<Encuesta> filtrarPorCriterio(List<Proyecto> proyectos);
	

}
