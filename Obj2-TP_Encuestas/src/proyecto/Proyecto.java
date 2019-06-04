package proyecto;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;

public class Proyecto {

	private String nombreProyecto;
	private List<Encuesta> encuestas;

	public Proyecto(String nombre) {  
		this.nombreProyecto = nombre; 
		this.encuestas = new ArrayList<Encuesta>();
	}

	public String getNombre() {
		return nombreProyecto;
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
	

}