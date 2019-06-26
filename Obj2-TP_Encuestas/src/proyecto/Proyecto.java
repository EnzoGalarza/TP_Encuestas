package proyecto;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;

public class Proyecto {

	private String descripcion;
	private List<Encuesta> encuestas;
	private String proposito;
	private List<Proyecto> subProyectos;

	public Proyecto(String unaDescripcion, String unProposito) {
		proposito = unProposito;
		descripcion = unaDescripcion;
		encuestas = new ArrayList<Encuesta>();
		subProyectos = new ArrayList<Proyecto>();
	}

	public String descripcion() {
		return descripcion;
	}
	
	public void agregarEncuesta(Encuesta unaEncuesta) {
		encuestas.add(unaEncuesta);
	}

	public List<Encuesta> getEncuestas() {
		return encuestas;
	}

	public Integer cantidadDeEncuestas() {
		return this.encuestas.size();
	}

	public String proposito() {
		return proposito;
	}
	
	public Boolean subProyectosFinalizados() {
		Boolean estaFinalizado = true;
		for(Proyecto p: subProyectos) {
			estaFinalizado = estaFinalizado && this.encuestasFinalizadas();
		}
		return estaFinalizado;
	}
	
	//Encuestas finalizadas
	public Boolean encuestasFinalizadas() {
		Boolean estaFinalizada = true;
		for(Encuesta e: encuestas) {
			estaFinalizada = estaFinalizada && e.finalizada();
		}
		return estaFinalizada;
	}
	
	//Agregar subproyecto si no contiene al proyecto contenedor
	public void agregarSubProyecto(Proyecto unSubProyecto) {
		if(noMeContieneComoSubProyecto(unSubProyecto)) {
			subProyectos.add(unSubProyecto);
		}
	}

	private boolean noMeContieneComoSubProyecto(Proyecto unSubProyecto) {
		// TODO Auto-generated method stub
	    Boolean meContiene = true;
		for(Proyecto p : unSubProyecto.getSubProyectos()) {
			meContiene = meContiene && !p.equals(this) && noMeContieneComoSubProyecto(p);
		}
		return meContiene;
	}

	//Lista de los proyectos
	public List<Proyecto> getSubProyectos() {
		return subProyectos;
	}

}