package encuesta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import proyecto.Proyecto;

public class CriterioPorProyecto extends CriterioDeBusqueda{

	@Override
	public List<Encuesta> filtrarPorCriterio(List<Encuesta> encuestas) {
		return null;
	}
	/*
	List<Proyecto> proyectos;
	
	public CriterioPorProyecto(List<Proyecto> proyectos) {
		this.proyectos = proyectos; 
	}
	@Override
	public List<Encuesta> filtrarPorCriterio(List<Encuesta> encuestas) {
		List<Encuesta> encuestasOrdenadas = new ArrayList<>();
		
		Collections.sort(proyectos, new Comparator<Proyecto>()
		{		
			public int compare(Proyecto e1, Proyecto e2) {
				return Integer.valueOf(e1.descripcion().compareTo(e2.descripcion()));
			}	
		});	
		
		for(Proyecto p: proyectos) {
			encuestasOrdenadas.addAll(p.getEncuestas());
		}
		
		
		return encuestasOrdenadas;
	}*/


}
