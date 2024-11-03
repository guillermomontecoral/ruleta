package obligatorio_dda.presentacion;

import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.presentacion.controlador.LoginJugadorControlador;

/**
 *
 * @author monte
 */
public class VentanaLoginJugador extends VentanaLogin {
    private Sesion sesion;

    public VentanaLoginJugador() {
        this.setControlador(new LoginJugadorControlador(this));
    }

    @Override
    public void ejecutarVentana(Sesion sesion) {
        
        new VentanaUnirseMesa(sesion).setVisible(true);
    }

}
