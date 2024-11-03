
package obligatorio_dda.dominio;

/**
 *
 * @author monte
 */
public class Ficha {
      

    public enum Valor{
        UNO(1),
        CINCO(5),
        DIEZ(10),
        CINCUENTA(50),
        CIEN(100);
        
        private int valor;
        
        Valor(int valor){
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

    }
}
