package workflow;

import pregunta.Pregunta;

public abstract class Nodo {

	protected abstract Boolean tieneSiguiente();

	public abstract Pregunta pregunta();
	
	public abstract Nodo ultimoNodo();

	protected abstract Pregunta ultimaPregunta();

	protected abstract void agregar(Pregunta pregunta);

	protected abstract Nodo getNodo(Pregunta pregunta);

	protected abstract Pregunta agregarHijoCon(Pregunta pregunta);
}
