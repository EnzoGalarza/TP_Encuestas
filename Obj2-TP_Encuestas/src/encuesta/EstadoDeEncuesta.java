package encuesta;

import java.util.Arrays;
import java.util.List;

import pregunta.Pregunta;
import respuesta.Respuesta;

public abstract class EstadoDeEncuesta {

	protected Encuesta encuesta;
	
    /*private static final List<EstadoDeEncuesta> ESTADOS =
    	Arrays.asList(new EstadoDeEncuestaDisponible(), new EstadoDeEncuestaCerrada());

    public static EstadoDeEncuesta estadoPara(Encuesta unaEncuesta) {
        return ESTADOS.stream().filter(state -> state.canHandle(unaEncuesta)).findFirst().get();
    }

    protected abstract Boolean canHandle(Encuesta unaEncuesta);*/
    
    public  void responder(Respuesta r) {
    	//Nothing.
    }
    
    public  void finalizarEdicion() {
    	//Nothing
    }
    
    public  void cerrarEncuesta() {
    	//Nothing
    }
    
    public  void guardarCambios() {
    	//Nothing
    }
    
    public  void setPregunta(Pregunta p) {
    	//Nothing
    }

	public Boolean esDisponible() {
		// TODO Auto-generated method stub
		return false;
	}
    
}

