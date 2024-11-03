
package utils;

/**
 *
 * @author digregor
 */
public interface Observador {
    
    public enum Evento {
        SESION_HA_CAMBIADO,
        MESA_ACTUALIZADA,
        APUESTA_ACTUALIZADA,
        SALDO_ACTUALIZADO,
        NUMERO_SORTEADO_ACTUALIZADO,
        PAGO_ACTUALIZADO
    }
    
    public void actualizar(Observable origen, Evento evento);
}
