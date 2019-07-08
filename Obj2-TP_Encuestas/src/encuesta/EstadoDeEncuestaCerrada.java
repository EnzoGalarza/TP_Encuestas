package encuesta;

public class EstadoDeEncuestaCerrada extends EstadoDeEncuesta{

	public EstadoDeEncuestaCerrada(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	/*@Override
	protected Boolean canHandle(Encuesta unaEncuesta) {
		throw new RuntimeException();
	}*/
	
	@Override
	public Boolean finalizada() {
		return true;
	}
	

}
