/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio_dda.servicios;

import java.util.ArrayList;
import java.util.List;
import obligatorio_dda.dominio.TipoEfecto;

/**
 *
 * @author monte
 */
public class ServicioEfecto {
    
       List<TipoEfecto> tipoEfectos;

    public ServicioEfecto() {
        this.tipoEfectos = new ArrayList();
    }
       
           
    public void agregar(TipoEfecto tipo){
        this.tipoEfectos.add(tipo);
    }

    public List<TipoEfecto> getTipoEfectos() {
        return tipoEfectos;
    }
}
