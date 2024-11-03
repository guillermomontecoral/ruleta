
package obligatorio_dda.presentacion.vista;

import obligatorio_dda.dominio.Sesion;

/**
 *
 * @author monte
 */
public interface LoginVista {
    
    public void setTitulo(String mensaje);
    public void mostrarMensajeError(String mensaje);
    public void cerrar();
    public void ejecutarVentana(Sesion sesion);
}
