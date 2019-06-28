package encuesta;

import java.util.Arrays;
import java.util.List;

public abstract class EstadoDeEncuesta {

    private static final List<EstadoDeEncuesta> ESTADOS =
    	Arrays.asList(new EstadoDeEncuestaDisponible(), new EstadoDeEncuestaCerrada());

    public static EstadoDeEncuesta estadoPara(Encuesta unaEncuesta) {
        return ESTADOS.stream().filter(state -> state.canHandle(unaEncuesta)).findFirst().get();
    }

    protected abstract Boolean canHandle(Encuesta unaEncuesta);
    
}

