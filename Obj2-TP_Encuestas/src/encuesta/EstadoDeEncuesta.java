package encuesta;

import java.util.Arrays;
import java.util.List;

import respuesta.Respuesta;

public abstract class EstadoDeEncuesta {

    private static final List<EstadoDeEncuesta> ESTADOS =
    	Arrays.asList(new EstadoDeEncuestaDisponible(), new EstadoDeEncuestaCerrada());

    public static EstadoDeEncuesta estadoPara(Encuesta unaEncuesta) {
        return ESTADOS.stream().filter(state -> state.canHandle(unaEncuesta)).findFirst().get();
    }
    
    protected abstract void agregarRespuestaPara(Encuesta unaEncuesta, Respuesta unaRespuesta);

    protected abstract Boolean canHandle(Encuesta unaEncuesta);
    
}

