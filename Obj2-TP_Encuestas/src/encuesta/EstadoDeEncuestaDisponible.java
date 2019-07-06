package encuesta;

import respuesta.Respuesta;

public class EstadoDeEncuestaDisponible extends EstadoDeEncuesta{

	public EstadoDeEncuestaDisponible(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
    
	/*
	@Override
	protected Boolean canHandle(Encuesta unaEncuesta) {
		return unaEncuesta.disponible() && !unaEncuesta.finalizada();
	}
	
	public void agregarPreguntaPara(Encuesta unaEncuesta) {
		unaEncuesta.encapsulador().agregarRespuestaRealizada(unaEncuesta.getPreguntaActual(),unaRespuesta);
		unaEncuesta.encapsulador().nuevaSesion();
		unaEncuesta.actualizarCantidadDeRespuestasEsperada();
	}*/
	
	@Override
	public void responder(Respuesta r) {
		this.encuesta.encapsulador().agregarRespuestaRealizada(this.encuesta.getPreguntaActual(), r);
		this.encuesta.getPreguntaActual().notificar(encuesta, r);
		r.notificar(encuesta, this.encuesta.getPreguntaActual());
		this.encuesta.workflow().siguiente(r);
	}
	
	@Override
	public void guardarCambios() { 
		 this.encuesta.encapsulador().nuevaSesion();
		 this.encuesta.actualizarCantidadDeRespuestasEsperada();
	}
	
	@Override
	public void cerrarEncuesta() {
		EstadoDeEncuesta nuevoEstado = new EstadoDeEncuestaCerrada(this.encuesta);
		this.encuesta.setEstado(nuevoEstado);
	}
	
	@Override
	public Boolean esDisponible() {
		return true;
	}

}
