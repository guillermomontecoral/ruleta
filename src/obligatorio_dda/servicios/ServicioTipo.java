
package obligatorio_dda.servicios;

import java.util.ArrayList;
import java.util.List;
import obligatorio_dda.dominio.TipoApuesta;

/**
 *
 * @author monte
 */
public class ServicioTipo {
    
    List<TipoApuesta> tipoApuestas;

    public ServicioTipo() {
        this.tipoApuestas = new ArrayList();
    }
    
    public void agregar(TipoApuesta tipoApuesta){
        tipoApuestas.add(tipoApuesta);
    }

    public List<TipoApuesta> getTipoApuestas() {
        return tipoApuestas;
    }
    
    
}
