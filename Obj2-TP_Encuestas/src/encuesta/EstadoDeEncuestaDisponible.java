package encuesta;

public class EstadoDeEncuestaDisponible extends EstadoDeEncuesta{

	@Override
	protected Boolean canHandle(Encuesta unaEncuesta) {
		return unaEncuesta.disponible() && !unaEncuesta.finalizada();
	}
	
	public void agregarPreguntaPara(Encuesta unaEncuesta) {
		unaEncuesta.encapsulador().agregarRespuestaRealizada(unaEncuesta.getPreguntaActual(),unaRespuesta);
		unaEncuesta.encapsulador().nuevaSesion();
		unaEncuesta.actualizarCantidadDeRespuestasEsperada();
	}
	

}
