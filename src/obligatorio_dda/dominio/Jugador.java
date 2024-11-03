package obligatorio_dda.dominio;

import java.util.ArrayList;
import java.util.List;
import utils.Observador;

/**
 *
 * @author monte
 */
public class Jugador extends Usuario {

    private int saldo;
    private List<Mesa> mesas;
    private List<Apuesta> apuestas;

    public Jugador() {
        this.mesas = new ArrayList();
        this.apuestas = new ArrayList();

    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
        this.notificar(Observador.Evento.SALDO_ACTUALIZADO);
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(Mesa mesa) {
        this.mesas.add(mesa);
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(Apuesta apuesta) {
        this.apuestas.add(apuesta);
    }

    public void actualizarSaldoParaApuesta(int valor) {
        this.setSaldo(this.getSaldo() - valor);
    }

    public void actualizarPago(int pago) {
        this.setSaldo(this.getSaldo() + pago);
    }

}
