package pregunta;

import respuesta.Respuesta;

public class PreguntaNula extends Pregunta {

	public PreguntaNula() {
		this.textoPregunta = "Pregunta nula";
	}
	
	@Override
	public String getTextoPregunta() {
		return this.textoPregunta;
	}

	@Override
	public Pregunta getSiguientePregunta(Respuesta r) {
		// TODO Auto-generated method stub
		return this;
	}
	
}
