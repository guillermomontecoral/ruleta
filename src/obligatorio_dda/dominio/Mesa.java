package obligatorio_dda.dominio;

import excepciones.MesaException;
import java.util.ArrayList;
import java.util.List;
import utils.Observable;
import utils.Observador;

/**
 *
 * @author monte
 */
public class Mesa extends Observable {

    private List<Ronda> rondas;
    private int balance;
    private List<Jugador> jugadores;
    private Crupier crupier;
    private List<TipoApuesta> tipoApuestas;
    private final int numeroMesa;
    private int numeroRondaActual;
    private List<Integer> ultimosLanzamientos;

    public Mesa(int numeroMesa) {
        this.balance = 0;
        this.numeroMesa = numeroMesa;
        this.rondas = new ArrayList();
        this.jugadores = new ArrayList();
        this.tipoApuestas = new ArrayList();
        this.ultimosLanzamientos = new ArrayList();
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(Ronda ronda) {
        this.rondas.add(ronda);
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador jugador) throws MesaException {

        if (jugadores.contains(jugador)) {
            throw new MesaException("Ya te encuentras dentro de la mesa.");
        }
        this.jugadores.add(jugador);
        this.notificar(Observador.Evento.MESA_ACTUALIZADA);
    }

    public void quitarJugador(Jugador jugador) throws MesaException {
        if (tieneApuestas(jugador)) {
            throw new MesaException("No se puede abandonar hasta compeltar la ronda");
        }
        
        jugadores.remove(jugador);
        this.notificar(Observador.Evento.MESA_ACTUALIZADA);
    }

    public Crupier getCrupier() {
        return crupier;
    }

    public void setCrupier(Crupier crupier) {
        this.crupier = crupier;
    }

    public List<TipoApuesta> getTipoApuestas() {
        return tipoApuestas;
    }

    public void setTipoApuestas(TipoApuesta tipoApuesta) {
        this.tipoApuestas.add(tipoApuesta);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getNumeroRondaActual() {
        return numeroRondaActual;
    }

    public void setNumeroRondaActual(int numeroRondaActual) {
        this.numeroRondaActual = numeroRondaActual;
    }

    public List<Integer> getUltimosLanzamientos() {
        return ultimosLanzamientos;
    }

    public void setUltimosLanzamientos(int ultimoLanzamiento) {
        this.ultimosLanzamientos.add(ultimoLanzamiento);
    }

    @Override
    public String toString() {
        return "Mesa: " + this.numeroMesa;
    }

    public Ronda getRondaActual() {

        this.setNumeroRondaActual(this.rondas.get(rondas.size() - 1).getNumeroRonda());
        return this.rondas.get(rondas.size() - 1);
    }

    public Casillero obtenerCasillero(int universalCellCode) {
        for (TipoApuesta t : this.tipoApuestas) {
            Casillero c = t.devolverCasillero(universalCellCode);
            if (c != null) {
                return c;
            }
        }
        return null;
    }

    public List<Integer> ultimosNumerosSorteados() {
        List<Integer> lista = new ArrayList();

        for (Ronda r : this.rondas) {
            lista.add(r.getNumeroSorteado());
        }
        return lista;
    }

    public boolean tieneApuestas(Jugador jugador) {
        for(Apuesta a: getRondaActual().getApuestas()){
            return a.getJugador().equals(jugador);
        }
        return false;
    }

    public void pagar() {
        Ronda rondaActual = getRondaActual();
        Apuesta apuesta = null;
        int pago = 0;
        int pagoTotal = 0;
        if (!rondaActual.getApuestasGanadores().isEmpty()) {
            for (Jugador j : getJugadores()) {
                pago = 0;
                for (Apuesta a : rondaActual.getApuestasGanadores()) {
                    if (a.getJugador().equals(j)) {
                        pago += a.getCasillero().getTipoApuesta().calcularPago(a.getTotalApostado());

                        a.getJugador().actualizarPago(pago);
                    }
                }
                pagoTotal += pago;
            }

        }

        this.getRondaActual().setTotalPago(pagoTotal);
        calcularBalance(pagoTotal);
        this.notificar(Observador.Evento.PAGO_ACTUALIZADO);

    }

    public void crearRonda() {
        Ronda ronda = new Ronda();
        ronda.setMesa(this);
        ronda.setNumeroRonda(this.getNumeroRondaActual() + 1);
        this.setRondas(ronda);

        this.notificar(Observador.Evento.MESA_ACTUALIZADA);
    }

    public void iniciarMesa(List<TipoApuesta> tipoApuestasSleccionadas) {
        this.crearRonda();
        for (TipoApuesta t : tipoApuestasSleccionadas) {
            this.setTipoApuestas(t);
        }
    }

    public void calcularBalance(int pago) {
        int total = 0;
        for (Apuesta a : this.getRondaActual().getApuestas()) {
            total += a.getTotalApostado();
        }
        setBalance(getBalance() + (total - pago));
    }

    public int getApuestas() {
        return this.getRondaActual().getApuestas().size();
    }
}
