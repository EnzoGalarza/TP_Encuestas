package workflow;

import java.util.ArrayList;

import pregunta.Pregunta;

public class NodoPadre extends Nodo{
	private Pregunta pregunta;
	private ArrayList<Nodo> nodosHijos = new ArrayList<>();
	
	public NodoPadre(Pregunta unaPregunta, Nodo unNodo) {
		pregunta = unaPregunta;
		nodosHijos.add(unNodo);
	}
	@Override
	protected Boolean tieneSiguiente() {
		return true;
	}
	
	public Nodo ultimoNodo() {
		for (Nodo n : nodosHijos) {
			if (n.tieneSiguiente()) {
				return n.ultimoNodo();
			}
			return this;
		}
		if (n.tieneSiguiente()) {
			return nodosHijos.ultimoNodo();
		}
		return this;
	}
	@Override
	public Pregunta pregunta() {
		return pregunta;
	}
	
	public Pregunta ultimaPregunta() {
		return ultimoNodo().pregunta();
	}
	@Override
	protected void agregar(Pregunta pregunta) {
		//Si el nodo actual tiene un siguiente agrega recursivamente hasta llegar al nodo vacío, si no, crea un un nodo padre
		if(nodosHijos.tieneSiguiente()) {
			nodosHijos.agregar(pregunta);
		}else {
			nodosHijos = new NodoPadre(pregunta, nodosHijos);
		}
	}
	@Override
	protected Nodo getNodo(Pregunta pregunta) {
		 if(!nodosHijos.pregunta().equals(pregunta)){
			 return null;
		}
		return nodosHijos;
	}
	@Override
	protected Pregunta agregarHijoCon(Pregunta pregunta) {
		return null;
	}


}