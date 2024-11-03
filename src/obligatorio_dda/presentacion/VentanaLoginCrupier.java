
package obligatorio_dda.presentacion;

import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.presentacion.controlador.LoginCrupierControlador;


/**
 *
 * @author monte
 */
public class VentanaLoginCrupier extends VentanaLogin{
    
    private Sesion sesion;

    public VentanaLoginCrupier() {
        this.setControlador(new LoginCrupierControlador(this));
    }
 

    @Override
    public void ejecutarVentana(Sesion sesion) {
        
        new VentanaIniciarMesa(sesion).setVisible(true);
    }
    
}
