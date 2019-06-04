package workflow;

import pregunta.Pregunta;
import pregunta.PreguntaDeSeleccion;
import respuesta.RespuestaCerrada;

public class WorkflowConArbol extends Workflow{

	private Nodo arbol = new NodoVacio();
	
	public Boolean tieneSiguiente() {
		return arbol.tieneSiguiente();
	}
	public Pregunta ultima() {
		return arbol.ultimaPregunta();
	}

	public void agregar(Pregunta pregunta) {
		if(!arbol.tieneSiguiente()) {
			arbol = new NodoPadre(pregunta, arbol);
		}
		arbol.agregar(pregunta);
	}
	public void agregarOtroCaminoPara(
			PreguntaDeSeleccion unaNuevaPregunta,
			RespuestaCerrada respuestaHabilitante, PreguntaDeSeleccion unaPreguntaExistente) {
		//Agrega un camino para una pregunta que sigue a una ya existe, en caso de obtener la respuesta habilitante. 
		
		//Implementar
	}
	public Pregunta obtener(Pregunta pregunta) {
		return arbol.getNodo(pregunta).pregunta();//.agregarHijoCon(pregunta);
	}
	
}