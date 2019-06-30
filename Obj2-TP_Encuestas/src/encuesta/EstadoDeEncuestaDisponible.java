package encuesta;

import respuesta.Respuesta;

public class EstadoDeEncuestaDisponible extends EstadoDeEncuesta{

	@Override
	protected Boolean canHandle(Encuesta unaEncuesta) {
		return unaEncuesta.disponible() && !unaEncuesta.finalizada();
	}
	
	public void agregarRespuestaPara(Encuesta unaEncuesta, Respuesta unaRespuesta) {
		unaEncuesta.encapsulador().agregarRespuestaRealizada(unaEncuesta.getPreguntaActual(),unaRespuesta);
		unaEncuesta.encapsulador().nuevaSesion();
		unaEncuesta.actualizarCantidadDeRespuestasEsperada();
	}
	

}
