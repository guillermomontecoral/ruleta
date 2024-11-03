/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio_dda.dominio;

import java.util.List;

/**
 *
 * @author monte
 */
public class Docena extends TipoApuesta {

    public Docena(String nombre, int factorDePago) {
        super(nombre, factorDePago);
    }

    @Override
    public int calcularPago(int monto) {
        return getFactorDePago() * monto;
    }

    @Override
    public boolean aplicarRestriccion(Apuesta apuesta, Mesa mesa) {
        Ronda ronda = mesa.getRondaActual();
        if (ronda != null) {
            List<Apuesta> apuestas = ronda.getApuestas();
            Jugador jugador = apuesta.getJugador();
            for (Apuesta a : apuestas) {
                if (a.getJugador().equals(jugador) && a.getCasillero().getUniversalCellCode() >= 40 && a.getCasillero().getUniversalCellCode() <= 42) {
                    int codigoApuesta = a.getCasillero().getUniversalCellCode();
                    int codigoDocenaNueva = apuesta.getCasillero().getUniversalCellCode();
                    if (codigoApuesta != codigoDocenaNueva) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
