package pregunta;

public class PreguntaNula extends Pregunta {

	public PreguntaNula() {
		this.textoPregunta = "Pregunta nula";
	}
	
	@Override
	public String getTextoPregunta() {
		return this.textoPregunta;
	}
	
}
