package obligatorio_dda.servicios;

import excepciones.MesaException;
import excepciones.UsuarioException;
import java.util.List;
import obligatorio_dda.dominio.Crupier;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.dominio.TipoApuesta;
import obligatorio_dda.dominio.TipoEfecto;
import utils.Observable;

/**
 *
 * @author monte
 */
public class ServicioFachada extends Observable{

    private static ServicioFachada instancia;
    private ServicioUsuario sUsuario;
    private ServicioMesa sMesa;
    private ServicioTipo sTipo;
    private ServicioEfecto sEfecto;

    public static ServicioFachada getInstancia() {
        if (instancia == null) {
            synchronized (ServicioFachada.class) {
                if (instancia == null) {
                    instancia = new ServicioFachada();
                }
            }
        }

        return instancia;
    }

    public ServicioFachada() {
        this.sUsuario = new ServicioUsuario();
        this.sMesa = new ServicioMesa();
        this.sTipo = new ServicioTipo();
        this.sEfecto = new ServicioEfecto();
    }

    public void agregar(Jugador j) {
        sUsuario.agregar(j);
    }

    public void agregar(Crupier c) {
        sUsuario.agregar(c);
    }

    public Sesion loginJugador(int cedula, String password) throws UsuarioException {
        return sUsuario.loginJugador(cedula, password);
    }


    public Sesion loginCrupier(int cedula, String password) throws UsuarioException {
        return sUsuario.loginCrupier(cedula, password);
    }

    public void logout(Sesion sesion) {
        sUsuario.logout(sesion);
    }

    public void agregar(TipoApuesta tipoApuesta) {
        sTipo.agregar(tipoApuesta);
    }

    public List<TipoApuesta> getTipoApuestas() {
        return sTipo.getTipoApuestas();
    }

    public void inicarMesa(Mesa mesa) throws MesaException {
        sMesa.inicarMesa(mesa);
    }

    public void cerrarMesa(Mesa mesa) {
        sMesa.cerrarMesa(mesa);
    }

    public List<Mesa> getMesas() {
        return sMesa.getMesas();
    }

    
    public void agregar(TipoEfecto tipo) {
        sEfecto.agregar(tipo);
    }

    public List<TipoEfecto> getTipoEfectos() {
        return sEfecto.getTipoEfectos();
    }

   
    
}
