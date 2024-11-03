/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package obligatorio_dda.presentacion.vista;

import java.util.List;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.TipoApuesta;
import obligatorio_dda.dominio.TipoEfecto;

/**
 *
 * @author monte
 */
public interface OperarVista {

    public void cerrar();

    public void mostrarNumeroSorteado(String numeroSorteado);

    public void mostrarNumeroMesa(String numeroMesa);

    public void mostrarNumeroRonda(String numeroRonda);

    public void activarTipoApuestasDeLaMesa(List<TipoApuesta> tipoApuestas);

    public void mostrarJugadoresActivos(List<Jugador> jugadoresActivos);

    public void cargarTipoEfectos(List<TipoEfecto> tipoEfectos);

    public void mostrarApuestasDeLosJugadores(int universalCellCode, int totalApostado);

    public void mostrarCantidadyTotalApostado(String cantidadApuestas, String cantidadApostado);

    public void limpiarPanel();

    public void mostrarBalance(String balance);
    
    public void ocultarNumeroSorteado();

    public void ultimosLanzamientos(List<Integer> ultimosLanzamientos);
    
    public void agregarFila(String ronda, String balanceAnterior, String apuestas, String recoleccion, String balancePosterior);
    
    public void mostrarNombreCrupier(String nombre);
}
