package observer;

import java.util.ArrayList;
import java.util.List;

import pregunta.Pregunta;
import respuesta.Respuesta;

public abstract class Observado {

	protected List<Observador> observadores = new ArrayList<Observador>();
	
	public void register(Observador o) {
		// agrega un observador a su lista de observadores
		this.observadores.add(o);
	}
	
	public void unregister(Observador o) {
		// elimina un observador de su lista de observadores
		this.observadores.remove(o);
	}
	
	public abstract void notify(Pregunta p, Respuesta r);

	public  Boolean esObservador(Observador observador) {
		return this.observadores.contains(observador);
	}
	
}
