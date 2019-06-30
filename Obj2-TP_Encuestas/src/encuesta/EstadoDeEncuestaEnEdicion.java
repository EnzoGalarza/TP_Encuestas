package encuesta;

import pregunta.Pregunta;

public class EstadoDeEncuestaEnEdicion extends EstadoDeEncuesta {

	public EstadoDeEncuestaEnEdicion(Encuesta encuesta) {
		// TODO Auto-generated constructor stub
		this.encuesta = encuesta;
	}

	@Override
	public void finalizarEdicion() {
		EstadoDeEncuesta nuevoEstado = new EstadoDeEncuestaDisponible(this.encuesta);
		this.encuesta.setEstado(nuevoEstado);
	}
	
	/*@Override
	protected Boolean canHandle(Encuesta unaEncuesta) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public void setPregunta(Pregunta p) {
		this.encuesta.workflow().setPregunta(p);
	}
	
}
