package apiladorDePreguntas;

import java.util.Stack;

import pregunta.Pregunta;

public class ApiladorDePregunta {

	private Stack<Pregunta> apilador;
	
	public ApiladorDePregunta() {
		this.apilador = new Stack<Pregunta>();
	}

	public void apilarPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		this.apilador.push(pregunta);
	}

	public Integer getCantidadDePreguntas() {
		// TODO Auto-generated method stub
		return this.apilador.size();
	}

	public Pregunta obtenerPregunta() {
		// TODO Auto-generated method stub
		return this.apilador.pop();
	}

	public void removerPregunta(Pregunta pregunta) {
		// TODO Auto-generated method stub
		this.apilador.remove(pregunta);
	}

	public Boolean tienePreguntas() {
		return getCantidadDePreguntas() > 0;
	}
	
}
