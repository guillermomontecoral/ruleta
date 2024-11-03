package obligatorio_dda.dominio;

import excepciones.JugadorException;
import excepciones.MesaException;
import java.util.ArrayList;
import java.util.List;
import utils.Observable;
import utils.Observador;

/**
 *
 * @author monte
 */
public class Ronda  extends Observable{

    private int numeroSorteado;
    private int numeroRonda;
    private Mesa mesa;
    private TipoEfecto tipoEfecto;
    List<Apuesta> apuestas;
    List<Apuesta> apuestasGanadores;
    List<Apuesta> apuestasPerdedoras;
    private Apuesta ultimaApuesta;
    private int totalPago;

    public Ronda() {
        this.numeroRonda = 0;
        this.numeroSorteado = 0;
        this.apuestas = new ArrayList();
        this.apuestasGanadores = new ArrayList();
        this.apuestasPerdedoras = new ArrayList();

    }

    public int getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(TipoEfecto tipoEfecto) {
        if (tipoEfecto != null) {
            this.numeroSorteado = tipoEfecto.sortear(mesa);
            mesa.setUltimosLanzamientos(this.numeroSorteado);
        }
        mesa.notificar(Observador.Evento.NUMERO_SORTEADO_ACTUALIZADO);
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
        mesa.notificar(Observador.Evento.MESA_ACTUALIZADA);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;

    }

    public TipoEfecto getTipoEfecto() {
        return tipoEfecto;
    }

    public void setTipoEfecto(TipoEfecto tipoEfecto) {
        this.tipoEfecto = tipoEfecto;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    private void setApuestas(Apuesta apuesta) {

        this.apuestas.add(apuesta);

    }

    public int getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(int totalPago) {
        this.totalPago = totalPago;
    }

    public Apuesta getUltimaApuesta() {
        return ultimaApuesta;
    }

    private void setUltimaApuesta(Apuesta ultimaApuesta) {
        this.ultimaApuesta = ultimaApuesta;
    }


    public int obtenerCantidadApuestas() {
        return this.apuestas.size();
    }

    public int obtenerDineroApostadoTotal() {
        int dineroTotal = 0;

        for (Apuesta a : this.apuestas) {
            dineroTotal += a.getTotalApostado();
        }

        return dineroTotal;
    }

    public Apuesta obtenerApuestas() {
        for (Apuesta a : getApuestas()) {

            return a;
        }
        return null;
    }

    public List<Apuesta> getApuestasGanadores() {
        return apuestasGanadores;
    }

    public void setApuestasGanadores(Apuesta apuestaGanadora) {
        this.apuestasGanadores.add(apuestaGanadora);
    }

    public List<Apuesta> getApuestasPerdedoras() {
        return apuestasPerdedoras;
    }

    public void setApuestasPerdedoras(List<Apuesta> apuestasPerdedoras) {
        this.apuestasPerdedoras = apuestasPerdedoras;
    }

    public void agregarApuestasGanadorasYPerdedoras() {
        for (Apuesta a : this.apuestas) {
            if (a.existeNumeroGanador(getNumeroSorteado())) {
                setApuestasGanadores(a);
                System.out.println("APUESTAS GANADORAS: " + a.getJugador().getNombreCompleto());
            }else{
                this.apuestasPerdedoras.add(a);
            }

        }

        if (getApuestasGanadores().isEmpty()) {
            System.out.println("NO HAY APUESTAS GANADORAS");
        }

    }

    public void crearApuesta(int universalCellCode, int valorFicha, Jugador jugador) throws JugadorException, MesaException {

        Casillero casillero = getMesa().obtenerCasillero(universalCellCode);

        if (jugador.getSaldo() < valorFicha) {
            throw new JugadorException("No tienes saldo suficiente para efectuar esa apuesta.");
        }

        Apuesta nuevaApuesta = new Apuesta();
        nuevaApuesta.setValorFicha(valorFicha);
        nuevaApuesta.setRonda(this);
        nuevaApuesta.setCasillero(casillero);
        nuevaApuesta.setTotalApostado(valorFicha);
        nuevaApuesta.setJugador(jugador);
        
        if(!casillero.getTipoApuesta().aplicarRestriccion(nuevaApuesta, mesa)){
            throw new JugadorException("No puedes apostar en mas de una docena por ronda");
        }        
        
        if (nuevaApuesta.validar(mesa)) {

            this.setApuestas(nuevaApuesta);
            this.setUltimaApuesta(nuevaApuesta);
            casillero.setApuestas(nuevaApuesta);
            jugador.actualizarSaldoParaApuesta(valorFicha);
        }

        mesa.notificar(Observador.Evento.APUESTA_ACTUALIZADA);
    }


   public List<Integer> obtenerNumerosApostadosDirecta() {
        List<Integer> numerosApostados = new ArrayList();
        if(!this.getApuestas().isEmpty()){
            for(Apuesta a : this.getApuestas()){
                if(a.getCasillero().getUniversalCellCode() < 37){
                    numerosApostados.add(a.getCasillero().getUniversalCellCode());
                }
            }
        }
        
        return numerosApostados;
    }
}
