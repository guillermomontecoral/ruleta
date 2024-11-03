package obligatorio_dda.presentacion.controlador;

import excepciones.JugadorException;
import excepciones.MesaException;
import obligatorio_dda.dominio.Apuesta;
import obligatorio_dda.dominio.Casillero;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Ronda;
import obligatorio_dda.presentacion.vista.JugarVista;
import obligatorio_dda.servicios.ServicioFachada;
import utils.Observable;
import utils.Observador;

public class JugarControlador implements Observador {

    private JugarVista jugarVista;
    private Mesa mesa;
    private Jugador jugador;
    private Ronda ronda;
    private Apuesta apuesta;
    private Casillero casillero;
    public boolean ok;

    public JugarControlador(JugarVista jugarVista, Mesa mesa, Jugador jugador) {
        this.jugarVista = jugarVista;
        this.mesa = mesa;
        this.jugador = jugador;

        ServicioFachada.getInstancia().subscribir(this);
        mesa.subscribir(this);
        jugador.subscribir(this);
        // ronda.subscribir(this);
        inicio();

    }

    public void crearApuesta(int universalCellCode, int valorFicha) {
        try {
            this.ronda = mesa.getRondaActual();
            ronda.crearApuesta(universalCellCode, valorFicha, jugador);
            ok = true;
        } catch (JugadorException | MesaException ex) {
            ok = false;
            jugarVista.mostrarMensajeError(ex.getMessage());
        }
    }

    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.MESA_ACTUALIZADA)) {
            this.actualizarDatos();

        }
        if (evento.equals(Observador.Evento.SALDO_ACTUALIZADO)) {
            jugarVista.mostrarSaldoJugador(String.valueOf(jugador.getSaldo()));
        }
        if (evento.equals(Observador.Evento.NUMERO_SORTEADO_ACTUALIZADO)) {
            this.mostrarNumeroSorteado();
            this.bloquearPanel();
        }
        if (evento.equals(Observador.Evento.PAGO_ACTUALIZADO)) {
            //mostrarNumeroSorteado();
            this.activarPanel();
        }

    }

    private void actualizarDatos() {
        jugarVista.numeroDeLaRonda(String.valueOf(mesa.getRondaActual().getNumeroRonda()));
        jugarVista.nombreDelJugador(jugador.getNombreCompleto());
    }

    private void inicio() {
        actualizarDatos();
        jugarVista.mostrarSaldoJugador(String.valueOf(jugador.getSaldo()));
        jugarVista.numeroRuleta(String.valueOf(mesa.getNumeroMesa()));
        jugarVista.activarTipoApuestasDeLaMesa(mesa.getTipoApuestas());
    }

    public void abandonarMesa() {
        try {
            this.mesa.quitarJugador(this.jugador);
            this.mesa.desubscribir(this);
            jugarVista.cerrar();
        } catch (MesaException ex) {
            jugarVista.mostrarMensajeError(ex.getMessage());
        }
    }

    public void mostrarNumeroSorteado() {
        this.ronda = mesa.getRondaActual();
        String numeroSorteado = String.valueOf(this.ronda.getNumeroSorteado());
        jugarVista.mostrarNumeroSorteado(numeroSorteado);
    }

    private void bloquearPanel() {
        jugarVista.bloquearPanel();
    }

    private void activarPanel() {
        jugarVista.activarPanel();
    }
}
