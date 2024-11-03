
package obligatorio_dda.dominio;

import excepciones.MesaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import utils.Observable;

/**
 *
 * @author monte
 */
public class Apuesta extends Observable{

    private List<Ficha> fichas;
    private int valorFicha;
    private int totalApostado;
    private Casillero casillero;
    private Ronda ronda;
    private Jugador jugador;

    public Apuesta() {
        //this.casillero = casillero;
        this.fichas = new ArrayList();
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(Ficha ficha) {
        this.fichas.add(ficha);
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(int totalApostado) { 
        this.totalApostado = totalApostado;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getValorFicha() {
        return valorFicha;
    }

    public void setValorFicha(int valorFicha) {
        this.valorFicha = valorFicha;
    }
    
    

    public boolean existeCasillero(int universalCellCode) {

        if (this.casillero != null) {
           return casillero.existe(universalCellCode);
        }
        return false;
    }

    public void actualizarValorDeApuesta(int valorFicha) {
        this.setTotalApostado(this.getTotalApostado() + valorFicha);
    }
    
    public boolean existeNumeroGanador(int numGanador){

        return this.casillero.getNumerosVinculados().contains(numGanador);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.jugador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Apuesta other = (Apuesta) obj;
        return Objects.equals(this.jugador, other.jugador);
    }

    public boolean validar(Mesa mesa) throws MesaException{
        
        if(ronda == null){
            throw new MesaException("la ronda es nula.");
        }
        
        if(casillero == null){
            throw new MesaException("El casillero es nulo.");
        }
        
        if(jugador == null){
            throw new MesaException("El jugador es nulo.");
        }
        
        if(valorFicha <= 0){
            throw new MesaException("Error en el valor de la ficha");            
        }
        
        return true;
    }    
    
}
