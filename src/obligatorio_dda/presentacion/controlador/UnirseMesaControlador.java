package obligatorio_dda.presentacion.controlador;

import excepciones.MesaException;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.presentacion.vista.UnirseMesaVista;
import obligatorio_dda.servicios.ServicioFachada;
import utils.Observable;
import utils.Observador;

/**
 *
 * @author monte
 */
public class UnirseMesaControlador implements Observador {

    private UnirseMesaVista unirseMesaVista;
    private Sesion sesion;
    private Jugador jugador;
    private Mesa mesa;

    public UnirseMesaControlador(Sesion sesion, UnirseMesaVista unirseMesaVista) {
        this.unirseMesaVista = unirseMesaVista;
        this.sesion = sesion;
        this.jugador = (Jugador) sesion.getUsuario();
        iniciar();

    }

    private void iniciar() {
        actualizarDatos();
        ServicioFachada.getInstancia().subscribir(this);
    }

    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.MESA_ACTUALIZADA)) {
            this.actualizarDatos();
        }
    }

    public void logout() {
        ServicioFachada.getInstancia().desubscribir(this);
        ServicioFachada.getInstancia().logout(sesion);
        unirseMesaVista.cerrar();
    }

    private void actualizarDatos() {
        unirseMesaVista.mostrarMesasAbiertas(ServicioFachada.getInstancia().getMesas());
        this.unirseMesaVista.nombreJugador(jugador.getNombreCompleto());
    }

    public void mesaSeleccionada(Mesa mesa) {
        this.mesa = mesa;
    }

    public void unirseMesa() {
        try {

            if (mesa != null) {
                this.mesa.setJugadores(jugador);
                this.jugador.setMesas(mesa);
                System.out.println("Mesa seleccionada " + mesa.toString());

                unirseMesaVista.abrilRuletaJugador(jugador, mesa);

            } else {
                unirseMesaVista.mostrarMensajeError("No has seleccionado ninguna mesa.");
            }

        } catch (MesaException ex) {
            unirseMesaVista.mostrarMensajeError(ex.getMessage());

        }
    }

}
