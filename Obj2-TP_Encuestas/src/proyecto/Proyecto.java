package proyecto;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;

public class Proyecto {

	private String descripcion;
	private List<Encuesta> encuestas;
	private String proposito;

	public Proyecto(String unaDescripcion, String unProposito) {
		proposito = unProposito;
		descripcion = unaDescripcion;
		encuestas = new ArrayList<Encuesta>();
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
	

}