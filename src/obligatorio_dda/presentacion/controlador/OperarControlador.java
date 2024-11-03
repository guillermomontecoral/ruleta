package obligatorio_dda.presentacion.controlador;

import java.util.List;
import obligatorio_dda.dominio.Crupier;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Ronda;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.dominio.TipoEfecto;
import obligatorio_dda.presentacion.vista.OperarVista;
import obligatorio_dda.servicios.ServicioFachada;
import utils.Observable;
import utils.Observador;

/**
 *
 * @author USUARIO
 */
public class OperarControlador implements Observador {

    private OperarVista operarVista;
    private Mesa mesa;
    private Crupier crupier;
    private Sesion sesion;
    private OperarControlador controlador;
    private Ronda ronda;
    private TipoEfecto tipoEfecto;
    //private int ultimoNumeroSorteado;

    public OperarControlador(OperarVista operarVista, Mesa mesa, Sesion sesion) {
        this.operarVista = operarVista;

        this.crupier = mesa.getCrupier();
        this.mesa = mesa;
        this.sesion = sesion;

        mesa.subscribir(this);

        iniciar();
    }

    @Override
    public void actualizar(Observable origen, Evento evento) {
        if (evento.equals(Observador.Evento.MESA_ACTUALIZADA)) {
            this.mostrarJugadores();
        }
        if (evento.equals(Observador.Evento.APUESTA_ACTUALIZADA)) {
            this.obtenerApuestasDeLosJugadores();
        }
        if (evento.equals(Observador.Evento.NUMERO_SORTEADO_ACTUALIZADO)) {
            operarVista.ultimosLanzamientos(mesa.getUltimosLanzamientos());
            operarVista.agregarFila(String.valueOf(mesa.getNumeroRondaActual()), String.valueOf(mesa.getBalance()), String.valueOf(mesa.getRondaActual().obtenerDineroApostadoTotal()), String.valueOf(mesa.getRondaActual().getTotalPago()), String.valueOf(mesa.getBalance()));
        }

    }

    private void iniciar() {
        cargarTipoEfectos();
        this.ronda = mesa.getRondaActual();
        operarVista.mostrarNumeroMesa(String.valueOf(mesa.getNumeroMesa()));
        operarVista.mostrarNombreCrupier(crupier.getNombreCompleto());
        operarVista.activarTipoApuestasDeLaMesa(mesa.getTipoApuestas());
        operarVista.ocultarNumeroSorteado();

        mostrarNumeroRonda();
        //operarVista.mostrarNumeroRonda(String.valueOf(mesa.getRondaActual().getNumeroRonda()));
    }

    public void cerrarMesa() {
        ServicioFachada.getInstancia().logout(sesion);
        ServicioFachada.getInstancia().cerrarMesa(mesa);
        mesa.desubscribir(this);
        operarVista.cerrar();
    }

    public void lanzar(TipoEfecto tipoEfecto) {
        ronda = mesa.getRondaActual();
        ronda.setNumeroSorteado(tipoEfecto);
        tipoEfecto.setRondas(ronda);
        String numeroSorteado = String.valueOf(this.ronda.getNumeroSorteado());
        operarVista.mostrarNumeroSorteado(numeroSorteado);
        ronda.subscribir(this); //Revisar si es necesario
        ronda.agregarApuestasGanadorasYPerdedoras();
    }

    public void pagar() {
        mesa.pagar();
        mesa.crearRonda();
        mostrarNumeroRonda();
        this.limpiarPanel();
        operarVista.mostrarBalance(String.valueOf(mesa.getBalance()));
        operarVista.ocultarNumeroSorteado();
        operarVista.mostrarCantidadyTotalApostado(String.valueOf(mesa.getRondaActual().obtenerCantidadApuestas()), String.valueOf(mesa.getRondaActual().obtenerDineroApostadoTotal()));
    }

    private void limpiarPanel() {
        operarVista.limpiarPanel();
    }

    private void obtenerApuestasDeLosJugadores() {
        operarVista.mostrarApuestasDeLosJugadores(mesa.getRondaActual().getUltimaApuesta().getCasillero().getUniversalCellCode(), mesa.getRondaActual().getUltimaApuesta().getValorFicha());

//        operarVista.mostrarCantidadyTotalApostado(String.valueOf(ronda.obtenerCantidadApuestas()), String.valueOf(ronda.obtenerDineroApostadoTotal()));
operarVista.mostrarCantidadyTotalApostado(String.valueOf(mesa.getRondaActual().obtenerCantidadApuestas()), String.valueOf(mesa.getRondaActual().obtenerDineroApostadoTotal()));
    }

    private void mostrarJugadores() {
        operarVista.mostrarJugadoresActivos(mesa.getJugadores());

    }

    public void cargarTipoEfectos() {
        List<TipoEfecto> tipos = ServicioFachada.getInstancia().getTipoEfectos();
        operarVista.cargarTipoEfectos(tipos);
    }

    private void mostrarNumeroRonda() {
        operarVista.mostrarNumeroRonda(String.valueOf(mesa.getRondaActual().getNumeroRonda()));
    }

}
