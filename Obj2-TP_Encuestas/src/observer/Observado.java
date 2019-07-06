package observer;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
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
	
	protected void notify(Encuesta e, Pregunta p, Respuesta r) {
		for(Observador o : this.observadores) {
			o.update(e, p, r);
		}
	}

	public  Boolean esObservador(Observador observador) {
		return this.observadores.contains(observador);
	}
	
}
