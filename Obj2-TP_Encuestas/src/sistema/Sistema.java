package sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import criterioDeBusqueda.CriterioDeBusqueda;
import encuesta.Encuesta;
import investigador.Investigador;
import proyecto.Proyecto;

public class Sistema {
	
	private List<Investigador> investigadores;
	
	public Sistema() {
		this.investigadores = new ArrayList<Investigador>();
	}
	
	public void registrarInvestigador(Investigador i) {
		this.investigadores.add(i);
	}

	public List<Investigador> getInvestigadores() {
		return this.investigadores;
	}

	public List<Encuesta> ordenarPorCriterio(CriterioDeBusqueda criterio) {
		return criterio.filtrarPorCriterio(this.getTodosLosProyectos());
	}

	private List<Proyecto> getTodosLosProyectos() {
		List<Proyecto> proyectos = new ArrayList<>(); 
		for (Investigador i : investigadores) {
			proyectos.addAll(i.getProyectos());
		}
		return proyectos;
	}

	
	
	
}
