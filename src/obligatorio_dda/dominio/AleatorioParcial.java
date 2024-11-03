/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio_dda.dominio;

import java.util.List;
import java.util.Random;

/**
 *
 * @author monte
 */
public class AleatorioParcial extends TipoEfecto {

    public AleatorioParcial(String nombre) {
        super(nombre);
    }


    @Override
    protected int sortear(Mesa mesa) {
        Random random = new Random();
        int numero = random.nextInt(37);

        while (ultimosTresNumero(mesa.getRondas(), numero)) {
            numero = random.nextInt(37);
        }

        return numero;
    }

    private boolean ultimosTresNumero(List<Ronda> rondas, int numero) {
        for (Ronda r : rondas) {
            if (r.getNumeroSorteado() == numero) {
                return true;
            }
        }
        return false;
    }
}
