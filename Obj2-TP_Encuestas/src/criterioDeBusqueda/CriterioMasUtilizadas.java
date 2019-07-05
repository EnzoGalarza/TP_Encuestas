package criterioDeBusqueda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import encuesta.Encuesta;
import proyecto.Proyecto;

public class CriterioMasUtilizadas extends CriterioDeBusqueda{
	
	private Integer cantMaximaPosible;
	
	public CriterioMasUtilizadas(Integer unaCantidadMaximaPosible) {
		cantMaximaPosible = unaCantidadMaximaPosible;
	}

	@Override
	public List<Encuesta> filtrarPorCriterio(List<Proyecto> proyectos) {
		throw new RuntimeException("Implementar que reciba proyectos");
	}










}
	
