
package obligatorio_dda.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monte
 */
public class Casillero {

    private String nombre;
    private List<Integer> numerosVinculados;
    private int universalCellCode;
    private List<Apuesta> apuestas;
    private TipoApuesta tipoApuesta;

    public Casillero() {
        this.numerosVinculados = new ArrayList();
        this.apuestas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getNumerosVinculados() {
        return numerosVinculados;
    }

    public void setNumerosVinculados(int num) {
        this.numerosVinculados.add(num);
    }
    public int getUniversalCellCode() {
        return universalCellCode;
    }

    public void setUniversalCellCode(int universalCellCode) {
        this.universalCellCode = universalCellCode;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(Apuesta apuesta) {
        this.apuestas.add(apuesta);
    }

    public TipoApuesta getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(TipoApuesta tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public boolean existe(int universalCellCode) {
        return universalCellCode == this.getUniversalCellCode();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.universalCellCode;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Casillero other = (Casillero) obj;
        return this.universalCellCode == other.universalCellCode;
    }



}
