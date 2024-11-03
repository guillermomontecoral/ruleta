
package obligatorio_dda.presentacion.controlador;

import excepciones.MesaException;
import java.util.List;
import obligatorio_dda.dominio.Crupier;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.dominio.TipoApuesta;
import obligatorio_dda.presentacion.vista.IniciarMesaVista;
import obligatorio_dda.servicios.ServicioFachada;

/**
 *
 * @author monte
 */
public class IniciarMesaControlador {

    private IniciarMesaVista iniciarMesaVista;
    private Crupier crupier;
    private Sesion sesion;
    private Mesa mesa;

    public IniciarMesaControlador(Sesion sesion, IniciarMesaVista iniciarMesaVista) {
        this.iniciarMesaVista = iniciarMesaVista;
        this.sesion = sesion;
        this.crupier = (Crupier) sesion.getUsuario();
        this.mesa = this.crupier.getMesa();
        iniciar();

    }

    public void iniciar() {
        this.iniciarMesaVista.nombreCrupier(crupier.getNombreCompleto());

        mostrarTiposApuestas();
    }

    public void mostrarTiposApuestas() {
        iniciarMesaVista.mostrarTiposApuestas(ServicioFachada.getInstancia().getTipoApuestas());
    }

    public int buscarIndice(List<TipoApuesta> tipoApuestas, String nombre) {
        for (int i = 0; i < tipoApuestas.size(); i++) {
            if (nombre.equals(tipoApuestas.get(i).getNombre())) {
                return i;
            }
        }
        return -1;
    }

    public void iniciarMesa(List<TipoApuesta> tipoApuestasSleccionadas) {

        try {
            ServicioFachada.getInstancia().inicarMesa(mesa);
   
            mesa.iniciarMesa(tipoApuestasSleccionadas);
            iniciarMesaVista.abrirRuletaCrupier(this.mesa, this.sesion);

        } catch (MesaException ex) {
            iniciarMesaVista.mostrarMensajeError(ex.getMessage());
        }

    }

    public void cerrarSesion() {
        ServicioFachada.getInstancia().logout(sesion);
    }

}
