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
public class Simulador extends TipoEfecto{

    public Simulador(String nombre) {
        super(nombre);
    }



    @Override
    protected int sortear(Mesa mesa) {
        Ronda ronda= mesa.getRondaActual();
        List<Integer> numerosApuestaDirecta = ronda.obtenerNumerosApostadosDirecta();
        
         // Crear una instancia de la clase Random
        Random random = new Random();

        // Obtener un índice aleatorio de la lista
        int indiceSorteado = random.nextInt(numerosApuestaDirecta.size());

        // Obtener el número correspondiente al índice sorteado
        return numerosApuestaDirecta.get(indiceSorteado);
    }
    


    
}
