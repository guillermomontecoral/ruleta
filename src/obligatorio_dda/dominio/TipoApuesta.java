package obligatorio_dda.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monte
 */
public abstract class TipoApuesta {

    private int factorDePago;
    private List<Casillero> casilleros;
    private String nombre;

    public TipoApuesta(String nombre, int factorDePago) {
        this.nombre = nombre;
        this.factorDePago = factorDePago;
        this.casilleros = new ArrayList();
    }

    public int getFactorDePago() {
        return factorDePago;
    }


    public List<Casillero> getCasilleros() {
        return casilleros;
    }

    public void setCasilleros(Casillero casillero) {
        this.casilleros.add(casillero);
    }


    public String getNombre() {
        return nombre;
    }

    public abstract int calcularPago(int monto);
   public abstract boolean aplicarRestriccion(Apuesta a, Mesa m);

    @Override
    public String toString() {
        return this.nombre;
    }

    public Casillero devolverCasillero(int universalCellCode) {
        for (Casillero c : getCasilleros()) {
            if (c.existe(universalCellCode)) {
                return c;
            }
            System.out.println(c.getNombre());
        }
        return null;
    }

}
