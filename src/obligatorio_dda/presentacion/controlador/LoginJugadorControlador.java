/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio_dda.presentacion.controlador;

import excepciones.UsuarioException;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.dominio.Usuario;
import obligatorio_dda.presentacion.vista.LoginVista;
import obligatorio_dda.servicios.ServicioFachada;

/**
 *
 * @author monte
 */
public class LoginJugadorControlador extends LoginControlador {

    private Sesion sesion;

    public LoginJugadorControlador(LoginVista loginVista) {
        super(loginVista);
        this.getLoginVista().setTitulo("Aplicacion para jugadores");
    }

    @Override
    protected Usuario login(String cedula, String password) throws UsuarioException, NumberFormatException {

        try {
            int cedulaInt = Integer.parseInt(cedula);
            sesion = ServicioFachada.getInstancia().loginJugador(cedulaInt, password);
            return (Jugador) sesion.getUsuario();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La cedula no puede estar vacia y debe contener solo numeros.");
        }
    }

    @Override
    protected void ejecutarVentana(Usuario usuario) {
        this.getLoginVista().ejecutarVentana(sesion);
    }

//    private int convertirEnInt(String string) {
//        try {
//            return Integer.parseInt(string);
//        } catch (NumberFormatException e) {
//            throw new NumberFormatException("La cedula no puede estar vacia y debe contener solo numeros.");
//        }
//    }

}
