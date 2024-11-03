
package obligatorio_dda.dominio;


/**
 *
 * @author monte
 */
public class Color extends TipoApuesta {

    public Color(String nombre, int factorDePago) {
        super(nombre, factorDePago);
    }
    
    
    @Override
    public int calcularPago(int monto) {
        return getFactorDePago() * monto;
    }

    @Override
    public boolean aplicarRestriccion(Apuesta a, Mesa m) {
        return true;
    }
    
}
