package criterioDeBusqueda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import encuesta.Encuesta;
import proyecto.Proyecto;

public class CriterioUltimasCreadas extends CriterioDeBusqueda {
	
	private Integer cantMaximaPosible;
	
	public CriterioUltimasCreadas(Integer unaCantidadMaximaPosible) {
		cantMaximaPosible = unaCantidadMaximaPosible;
	}

	@Override
	public List<Encuesta> filtrarPorCriterio(List<Proyecto> proyectos) {
		
		List<Encuesta> encuestas = new ArrayList<Encuesta>();
		
		for(Proyecto p: proyectos) {
			encuestas.addAll(p.getEncuestas()); //todas las encuestas en proyectos
		}
		
		Collections.sort(encuestas, new Comparator<Encuesta>(){		//ordena las encuestas por su fecha
			public int compare(Encuesta e1, Encuesta e2) {
				return Integer.valueOf(e2.fechaDeCreacion().compareTo(e1.fechaDeCreacion()));
			}
		});
		
			if(encuestas.size() < cantMaximaPosible) {
				cantMaximaPosible =  encuestas.size();
			}
			 
		return encuestas.subList(0,cantMaximaPosible);
	}
}
