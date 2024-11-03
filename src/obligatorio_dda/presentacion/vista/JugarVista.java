/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio_dda.presentacion.vista;

import java.util.List;
import obligatorio_dda.dominio.TipoApuesta;

/**
 *
 * @author USUARIO
 */
public interface JugarVista {

    public void mostrarMensajeError(String mensaje);

    public void cerrar();

    public void mostrarNumeroSorteado(String numeroSorteado);

    public void nombreDelJugador(String nombre);

    public void numeroDeLaRonda(String numeroRonda);

    public void numeroRuleta(String numeroRuleta);

    public void activarTipoApuestasDeLaMesa(List<TipoApuesta> tipoApuestas);

    public void mostrarSaldoJugador(String saldo);
    
      public void bloquearPanel();

    public void activarPanel();
}
