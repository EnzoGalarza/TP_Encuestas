package apiladorDePreguntas;

import java.util.Stack;

import pregunta.Pregunta;

public class ApiladorDePregunta {

	private Stack<Pregunta> apilador;
	
	public ApiladorDePregunta() {
		this.apilador = new Stack<Pregunta>();
	}

	public void apilarPregunta(Pregunta pregunta) {
		// Agrega una Pregunta al stack
		this.apilador.push(pregunta);
	}

	public Integer getCantidadDePreguntas() {
		// Retorna la cantidadDePreguntas del stack
		return this.apilador.size();
	}

	public Pregunta obtenerPregunta() {
		// Saca y retorna la ultima pregunta en entrar al stack
		return this.apilador.pop();
	}

	public void removerPregunta(Pregunta pregunta) {
		// Saca una pregunta del stack
		this.apilador.remove(pregunta);
	}

	public Boolean tienePreguntas() {
		// Retorna si el stack tiene alguna pregunta
		return !this.apilador.empty();
	}
	
}
