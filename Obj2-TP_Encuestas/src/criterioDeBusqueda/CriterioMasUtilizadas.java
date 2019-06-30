package criterioDeBusqueda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import encuesta.Encuesta;

public class CriterioMasUtilizadas extends CriterioDeBusqueda{
	
	private Integer cantMaximaPosiible = 25;

	@Override
	public List<Encuesta> filtrarPorCriterio(List<Encuesta> encuestas) {
		Collections.sort(encuestas, new Comparator<Encuesta>(){		
			public int compare(Encuesta e1, Encuesta e2) {
				return Integer.valueOf(e1.cantidadDeRespuestasCompletas().compareTo(e2.cantidadDeRespuestasCompletas()));
			}	
		});	
		if(encuestas.size() < cantMaximaPosiible) {
			cantMaximaPosiible =  encuestas.size();
		}
		return encuestas.subList(0, cantMaximaPosiible);
	}









}
	
