package obligatorio_dda.servicios;

import excepciones.UsuarioException;
import java.util.ArrayList;
import java.util.List;
import obligatorio_dda.dominio.*;

/**
 *
 * @author monte
 */
public class ServicioUsuario {

    private final List<Jugador> usuariosJugador;
    private final List<Crupier> usuariosCrupier;
    private final List<Sesion> usuariosConectados;

    public ServicioUsuario() {
        this.usuariosJugador = new ArrayList();
        this.usuariosCrupier = new ArrayList();
        this.usuariosConectados = new ArrayList();
    }

    public void agregar(Jugador j) {
        this.usuariosJugador.add(j);
    }

    public void agregar(Crupier c) {
        this.usuariosCrupier.add(c);
    }

    public Sesion loginJugador(int cedula, String password) throws UsuarioException {
        Jugador j = (Jugador) login(cedula, password, (List) usuariosJugador);
        this.usuarioConectado(cedula);
        Sesion s = new Sesion(j);
        usuariosConectados.add(s);
        return s;
    }


    public Sesion loginCrupier(int cedula, String password) throws UsuarioException {
        Crupier c = (Crupier) login(cedula, password, (List) usuariosCrupier);
        this.usuarioConectado(cedula);
        Sesion s = new Sesion(c);
        usuariosConectados.add(s);
        return s;
    }

    private void usuarioConectado(int cedula) throws UsuarioException {
        for (Sesion s : usuariosConectados) {
            if (s.getUsuario().getCedula() == cedula) {
                throw new UsuarioException("Acceso denegado. El usuario ya tiene una sesión activa.");
            }
        }
    }

    private Usuario login(int cedula, String password, List<Usuario> listaUsuarios) throws UsuarioException, NumberFormatException {
        
        if (password.equals("")) {
            throw new UsuarioException("Contraseña vacia.");
        }
        
        Usuario usu = null;
        for (Usuario u : listaUsuarios) {
            if (u.getCedula() == cedula && u.getPassword().equals(password)) {
                usu = u;
            }
        }
        
        if (usu == null) {
            throw new UsuarioException("Credenciales incorrectas.");
        }
        return usu;
    }

    public void logout(Sesion sesion) {
        usuariosConectados.remove(sesion);
    }
}
