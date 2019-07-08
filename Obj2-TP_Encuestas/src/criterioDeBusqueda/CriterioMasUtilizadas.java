package criterioDeBusqueda;

import java.util.ArrayList;
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
		
		List<Encuesta> encuestas = new ArrayList<Encuesta>();
		
		for(Proyecto p: proyectos) { //todas las encuestas
			encuestas.addAll(p.getEncuestas());
		}
		
		
		Collections.sort(encuestas, new Comparator<Encuesta>() { //ordenas las encuestas por su cantDeRespuestas 
			public int compare(Encuesta e1, Encuesta e2) {
				return Integer.valueOf(e1.cantidadDeRespuestasCompletas().compareTo(e2.cantidadDeRespuestasCompletas()));
			}	
		});	
		
			if(encuestas.size() < cantMaximaPosible) {
				cantMaximaPosible =  encuestas.size();
			}
			
		return encuestas.subList(0, cantMaximaPosible);
	}
}
	
