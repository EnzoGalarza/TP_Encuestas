package encuesta;

import respuesta.Respuesta;

public class EstadoDeEncuestaCerrada extends EstadoDeEncuesta{

	@Override
	protected Boolean canHandle(Encuesta unaEncuesta) {
		return unaEncuesta.finalizada();
	}

	@Override
	protected void agregarRespuestaPara(Encuesta unaEncuesta, Respuesta unaRespuesta) {
		throw new RuntimeException("Error: esta cerrada");
	}



}
