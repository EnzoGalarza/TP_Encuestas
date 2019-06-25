package investigador;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import encuesta.Encuesta;
import observer.Observador;
import pregunta.Pregunta;
import proyecto.Proyecto;
import respuesta.Respuesta;

public class Investigador implements Observador{

	private String user;
	private String password;
	private List<Proyecto> proyectos;
	
	public Investigador(String user, String password) { 
		this.user = user;
		this.password = password; 
		this.proyectos = new ArrayList<Proyecto>();
	}
	
	public String getUser() {
		return this.user;
	} 
	
	public String getPassword() {
		return this.password;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void agregarProyecto(Proyecto unProyecto) {
		this.proyectos.add(unProyecto);
	}

	public void crearProyecto(String unaDescripcion, String unProposito) {
		proyectos.add(new Proyecto(unaDescripcion, unProposito));
	}

	public Boolean tieneProyectos() {
		return !proyectos.isEmpty();
	}

	@Override
	public void update(Encuesta e, Pregunta p, Respuesta r) {
		//Hacer algo??
	}

}


