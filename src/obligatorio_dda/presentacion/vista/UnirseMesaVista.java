package obligatorio_dda.presentacion.vista;

import java.util.List;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Sesion;

/**
 *
 * @author monte
 */
public interface UnirseMesaVista {

    public void mostrarMesasAbiertas(List<Mesa> mesas);

    public void abrilRuletaJugador(Jugador jugador, Mesa mesa);

    public void mostrarMensajeError(String mensaje);

    public void cerrar();

    public void nombreJugador(String nombreCompleto);
}
