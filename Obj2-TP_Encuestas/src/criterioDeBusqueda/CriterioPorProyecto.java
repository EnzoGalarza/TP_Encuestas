package criterioDeBusqueda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import encuesta.Encuesta;
import proyecto.Proyecto;

public class CriterioPorProyecto implements CriterioDeBusqueda{

	@Override
	public List<Encuesta> filtrarPorCriterio(List<Proyecto> proyectos) {
		
		List<Encuesta> encuestasOrdenadas = new ArrayList<>();
		
		Collections.sort(proyectos, new Comparator<Proyecto>()
		{		
			public int compare(Proyecto e1, Proyecto e2) { //ordena los proyectos alfabeticamente
				return Integer.valueOf(e1.descripcion().compareTo(e2.descripcion()));
			}	
		});	
		
		for(Proyecto p: proyectos) { //primero aparecen las encuestas del primer proyecto ordeanado alfabeticamente
			encuestasOrdenadas.addAll(p.getEncuestas());
		}
		
		
		return encuestasOrdenadas;
	}
} 
