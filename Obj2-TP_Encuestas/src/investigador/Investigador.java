package investigador;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import encuesta.Encuesta;
import observer.Observador;
import pregunta.Pregunta;
import pregunta.PreguntaNula;
import proyecto.Proyecto;
import respuesta.Respuesta;
import workflow.Workflow;

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

	public Encuesta crearEncuesta(Proyecto proyecto1, Integer cantRespuestasCompletasEsperadas) {
		Workflow workflow = new Workflow(new PreguntaNula());
		Encuesta unaEncuesta = new Encuesta(workflow, cantRespuestasCompletasEsperadas, LocalDate.of(2019, Month.JULY, 1));
		
		proyecto1.agregarEncuesta(unaEncuesta);
		return unaEncuesta;
	}

	public Long cantidadDeEncuestasEn(Proyecto unProyecto) {
		return proyectos.stream().filter(proyecto -> proyecto.equals(unProyecto)).count();
	}

	public void setearPregunta(Encuesta encuesta, Pregunta pregunta1) {
		encuesta.setPregunta(pregunta1);		
	}

}


