package obligatorio_dda.presentacion.vista;

import java.util.List;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.dominio.TipoApuesta;

/**
 *
 * @author monte
 */
public interface IniciarMesaVista {

    public void mostrarTiposApuestas(List<TipoApuesta> tipoApuestas);

    public List<TipoApuesta>  obtenerTipoApuestasSeleccionados();

    public void cerrar();

    public void mostrarMensajeError(String mensaje);
    
    public void abrirRuletaCrupier(Mesa mesa, Sesion sesion);

    public void nombreCrupier(String nombreCompleto);
    //public void iniciarMesa(List<TipoApuesta> tipoApuestasSeleccionadas);
}
