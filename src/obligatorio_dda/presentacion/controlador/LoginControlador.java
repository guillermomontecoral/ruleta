package obligatorio_dda.presentacion.controlador;

import excepciones.UsuarioException;
import obligatorio_dda.dominio.Usuario;
import obligatorio_dda.presentacion.vista.LoginVista;

/**
 *
 * @author monte
 */
public abstract class LoginControlador {

    private LoginVista loginVista;

    public LoginControlador(LoginVista loginVista) {
        this.loginVista = loginVista;
        this.loginVista.setTitulo("");
    }

    public LoginVista getLoginVista() {
        return loginVista;
    }

    public void loginUsuario(String userName, String password) {
        try {
            Usuario usuario = this.login(userName, password);
            this.ejecutarVentana(usuario);
            this.loginVista.cerrar();
        } catch (UsuarioException | NumberFormatException ex) {
            this.loginVista.mostrarMensajeError(ex.getMessage());
        }
    }

    public void cerrar() {
        this.loginVista.cerrar();
    }

    protected abstract Usuario login(String cedula, String password) throws UsuarioException;

    protected abstract void ejecutarVentana(Usuario usuario);

}
