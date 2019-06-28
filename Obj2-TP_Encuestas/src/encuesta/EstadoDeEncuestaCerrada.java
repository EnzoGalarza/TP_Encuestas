package encuesta;

public class EstadoDeEncuestaCerrada extends EstadoDeEncuesta{

	@Override
	protected Boolean canHandle(Encuesta unaEncuesta) {
		throw new RuntimeException();
	}



}
