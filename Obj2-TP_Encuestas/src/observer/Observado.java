package observer;

import java.util.ArrayList;
import java.util.List;

import pregunta.Pregunta;
import respuesta.Respuesta;

public abstract class Observado {

	protected List<Observador> observadores = new ArrayList<Observador>();
	
	public void register(Observador o) {
		this.observadores.add(o);
	}
	
	public void unregister(Observador o) {
		this.observadores.remove(o);
	}
	
	public abstract void notify(Pregunta p, Respuesta r);

	public  Boolean esObservador(Observador observador) {
		return this.observadores.contains(observador);
	}
	
}
