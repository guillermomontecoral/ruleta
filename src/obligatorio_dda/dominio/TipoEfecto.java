
package obligatorio_dda.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monte
 */
public abstract class TipoEfecto {
    
    private List<Ronda> rondas;
    private String nombre;

    public TipoEfecto(String nombre) {
        this.nombre = nombre;
        this.rondas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }    

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(Ronda ronda) {
        this.rondas.add(ronda);
    }    
    
    protected abstract int sortear(Mesa mesa);

    @Override
    public String toString() {
        return  nombre;
    }    
    
}
