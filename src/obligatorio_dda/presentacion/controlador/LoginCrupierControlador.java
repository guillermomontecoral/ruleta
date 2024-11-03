/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obligatorio_dda.presentacion.controlador;

import excepciones.UsuarioException;
import obligatorio_dda.dominio.Crupier;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.dominio.Usuario;
import obligatorio_dda.presentacion.vista.LoginVista;
import obligatorio_dda.servicios.ServicioFachada;

/**
 *
 * @author monte
 */
public class LoginCrupierControlador extends LoginControlador {

    private Sesion sesion;

    public LoginCrupierControlador(LoginVista loginVista) {
        super(loginVista);
        this.getLoginVista().setTitulo("Aplicacion para crupiers");
    }

    @Override
    protected Usuario login(String cedula, String password) throws UsuarioException, NumberFormatException {

        try {
            int cedulaInt = Integer.parseInt(cedula);
            sesion = ServicioFachada.getInstancia().loginCrupier(cedulaInt, password);
            return (Crupier) sesion.getUsuario();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La cedula no puede estar vacia y debe contener solo numeros.");
        }
    }

    @Override
    protected void ejecutarVentana(Usuario usuario) {

        this.getLoginVista().ejecutarVentana(sesion);
    }


}
