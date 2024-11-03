package obligatorio_dda.servicios;

import excepciones.MesaException;
import java.util.ArrayList;
import java.util.List;
import obligatorio_dda.dominio.Apuesta;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.TipoEfecto;
import utils.Observador;

/**
 *
 * @author monte
 */
public class ServicioMesa {

    List<Mesa> mesas;
//   List<Jugador> jugadoresEnLaMesa;

    public ServicioMesa() {
        this.mesas = new ArrayList();

    }

    public void inicarMesa(Mesa mesa) throws MesaException {
        if (mesa == null) {
            throw new MesaException("Error. No tienes una mesa asignada.");
        }

        if (mesas.contains(mesa)) {
            throw new MesaException("Error. La mesa ya se encuentra iniciada.");
        }
        mesas.add(mesa);
        ServicioFachada.getInstancia().notificar(Observador.Evento.MESA_ACTUALIZADA);
    }

    public void cerrarMesa(Mesa mesa) {
        mesas.remove(mesa);
        ServicioFachada.getInstancia().notificar(Observador.Evento.MESA_ACTUALIZADA);
    }

    public List<Mesa> getMesas() {
        return mesas;
    }


}
