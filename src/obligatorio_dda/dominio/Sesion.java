
package obligatorio_dda.dominio;

import java.util.Date;

/**
 *
 * @author monte
 */
public class Sesion {
    
    private Date horaIngreso;
    private Usuario usuario;

    public Sesion(Usuario usuario) {
        this.horaIngreso = new Date();
        this.usuario = usuario;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    
    
}
