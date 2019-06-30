package criterioDeBusqueda;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import encuesta.Encuesta;

public class CriterioUltimasCreadas extends CriterioDeBusqueda {

	private Integer cantMaximaPosiible = 20;

	@Override
	public List<Encuesta> filtrarPorCriterio(List<Encuesta> encuestas) {
		//Retorna las ultimas 20 encuestas creadas por fecha
			Collections.sort(encuestas, new Comparator<Encuesta>(){		
				public int compare(Encuesta e1, Encuesta e2) {
					return Integer.valueOf(e2.fechaDeCreacion().compareTo(e1.fechaDeCreacion()));
				}
			});
			if(encuestas.size() < cantMaximaPosiible) {
			cantMaximaPosiible =  encuestas.size();
			}
			return encuestas.subList(0,cantMaximaPosiible);
	}

	

}
