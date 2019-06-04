package workflow;

import pregunta.Pregunta;

public class NodoVacio extends Nodo {

	@Override
	protected Boolean tieneSiguiente() {
		return false;
	}

	@Override
	public Pregunta pregunta() {
		throw new  RuntimeException("Error");
	}

	@Override
	public Nodo ultimoNodo() {
		throw new  RuntimeException("Error");
	}

	@Override
	protected Pregunta ultimaPregunta() {
		throw new  RuntimeException("Error");
	}

	@Override
	protected void agregar(Pregunta pregunta) {
	}

	@Override
	protected Nodo getNodo(Pregunta pregunta) {
		return null;
	}

	@Override
	protected Pregunta agregarHijoCon(Pregunta pregunta) {
		return null;
	}
}