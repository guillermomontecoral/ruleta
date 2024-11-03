package obligatorio_dda.dominio;

import java.util.Random;

/**
 *
 * @author monte
 */
public class AleatorioCompleto extends TipoEfecto {


    public AleatorioCompleto(String nombre) {
        super(nombre);
    }

    @Override
    protected int sortear(Mesa mesa) {
        Random random = new Random();
        int numero = random.nextInt(37);
        return numero;
    }

}
