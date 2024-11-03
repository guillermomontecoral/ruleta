package obligatorio_dda;

import obligatorio_dda.dominio.AleatorioCompleto;
import obligatorio_dda.dominio.AleatorioParcial;
import obligatorio_dda.dominio.Casillero;
import obligatorio_dda.dominio.Color;
import obligatorio_dda.dominio.Crupier;
import obligatorio_dda.dominio.Directa;
import obligatorio_dda.dominio.Docena;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Simulador;
import obligatorio_dda.dominio.TipoApuesta;
import obligatorio_dda.dominio.TipoEfecto;
import obligatorio_dda.presentacion.VentanaInicio;
import obligatorio_dda.servicios.ServicioFachada;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        precargaDatos();
        new VentanaInicio().setVisible(true);
    }

    private static void precargaDatos() {
        ServicioFachada f = ServicioFachada.getInstancia();

        //Mesas
        Mesa m1 = new Mesa(1);
        Mesa m2 = new Mesa(2);
        Mesa m3 = new Mesa(3);
        Mesa m4 = new Mesa(4);
        Mesa m5 = new Mesa(5);

        //Crupiers
        Crupier c1 = new Crupier();
        c1.setCedula(101);
        c1.setPassword("aaa");
        c1.setNombreCompleto("Roberto Carlos");
        c1.setMesa(m1);
        m1.setCrupier(c1);

        Crupier c2 = new Crupier();
        c2.setCedula(102);
        c2.setPassword("bbb");
        c2.setNombreCompleto("Estelita Brasil");
        c2.setMesa(m2);
        m2.setCrupier(c2);

        Crupier c3 = new Crupier();
        c3.setCedula(103);
        c3.setPassword("ccc");
        c3.setNombreCompleto("Natalia Oreiro");
        c3.setMesa(m3);
        m3.setCrupier(c3);

        Crupier c4 = new Crupier();
        c4.setCedula(104);
        c4.setPassword("ddd");
        c4.setNombreCompleto("Rick Grimes");
        c4.setMesa(m4);
        m4.setCrupier(c4);

        Crupier c5 = new Crupier();
        c5.setCedula(105);
        c5.setPassword("eee");
        c5.setNombreCompleto("Mirtha Legrand");

        f.agregar(c1);
        f.agregar(c2);
        f.agregar(c3);
        f.agregar(c4);
        f.agregar(c5);

        //Jugadores
        Jugador j1 = new Jugador();
        j1.setCedula(201);
        j1.setPassword("aaa");
        j1.setNombreCompleto("Zulma Lobato");
        j1.setSaldo(1000);

        Jugador j2 = new Jugador();
        j2.setCedula(202);
        j2.setPassword("bbb");
        j2.setNombreCompleto("Harry Potter");
        j2.setSaldo(500);

        Jugador j3 = new Jugador();
        j3.setCedula(203);
        j3.setPassword("ccc");
        j3.setNombreCompleto("Homero Simpson");
        j3.setSaldo(100);

        Jugador j4 = new Jugador();
        j4.setCedula(204);
        j4.setPassword("ddd");
        j4.setNombreCompleto("Emma Stone");
        j4.setSaldo(50);

        Jugador j5 = new Jugador();
        j5.setCedula(205);
        j5.setPassword("eee");
        j5.setNombreCompleto("Dan Reynolds");
        j5.setSaldo(10);

        Jugador j6 = new Jugador();
        j6.setCedula(206);
        j6.setPassword("fff");
        j6.setNombreCompleto("Luis Suarez");
        j6.setSaldo(1200);

        f.agregar(j1);
        f.agregar(j2);
        f.agregar(j3);
        f.agregar(j4);
        f.agregar(j5);
        f.agregar(j6);

        //Tipo Apuestas
        TipoApuesta directa = new Directa("Directa", 36);
        TipoApuesta docena = new Docena("Docena", 3);
        TipoApuesta color = new Color("Color", 2);

        f.agregar(directa);
        f.agregar(docena);
        f.agregar(color);

        //Casilleros
        //Directo
        Casillero casilleroDirecta = new Casillero();
        for (int i = 0; i < 37; i++) {
            casilleroDirecta = new Casillero(); // Crea un nuevo Casillero en cada iteración
           casilleroDirecta.setNumerosVinculados(i);
            casilleroDirecta.setUniversalCellCode(i);
            casilleroDirecta.setNombre("Directa " + i);
            casilleroDirecta.setTipoApuesta(directa);
            directa.setCasilleros(casilleroDirecta);
        }
        for (int i = 0; i < 37; i++) {
            casilleroDirecta.setNumerosVinculados(i);
        }

        //Docena
        Casillero casilleroPrimeraDocena = new Casillero();
        casilleroPrimeraDocena.setNombre("Primera Docena ");
        docena.setCasilleros(casilleroPrimeraDocena);
        for (int i = 1; i < 13; i++) {
            casilleroPrimeraDocena.setNumerosVinculados(i);
            casilleroPrimeraDocena.setTipoApuesta(docena);
            casilleroPrimeraDocena.setUniversalCellCode(40);
        }

        Casillero casilleroSegundaDocena = new Casillero();
        casilleroSegundaDocena.setNombre("Segunda Docena ");
        docena.setCasilleros(casilleroSegundaDocena);
        for (int i = 13; i < 25; i++) {
            casilleroSegundaDocena.setNumerosVinculados(i);
            casilleroSegundaDocena.setTipoApuesta(docena);
            casilleroSegundaDocena.setUniversalCellCode(41);
        }

        Casillero casilleroTerceraDocena = new Casillero();
        casilleroTerceraDocena.setNombre("Tercera Docena ");
        docena.setCasilleros(casilleroTerceraDocena);
        for (int i = 25; i < 37; i++) {
            casilleroTerceraDocena.setNumerosVinculados(i);
            casilleroTerceraDocena.setTipoApuesta(docena);
            casilleroTerceraDocena.setUniversalCellCode(42);
        }

        //Casillero Color
        //Rojo
        Casillero casilleroRojo = new Casillero();
        casilleroRojo.setNombre("Rojo");
        casilleroRojo.setNumerosVinculados(1);
        casilleroRojo.setNumerosVinculados(3);
        casilleroRojo.setNumerosVinculados(5);
        casilleroRojo.setNumerosVinculados(7);
        casilleroRojo.setNumerosVinculados(9);
        casilleroRojo.setNumerosVinculados(12);
        casilleroRojo.setNumerosVinculados(14);
        casilleroRojo.setNumerosVinculados(18);
        casilleroRojo.setNumerosVinculados(16);
        casilleroRojo.setNumerosVinculados(21);
        casilleroRojo.setNumerosVinculados(19);
        casilleroRojo.setNumerosVinculados(23);
        casilleroRojo.setNumerosVinculados(27);
        casilleroRojo.setNumerosVinculados(25);
        casilleroRojo.setNumerosVinculados(30);
        casilleroRojo.setNumerosVinculados(32);
        casilleroRojo.setNumerosVinculados(35);
        casilleroRojo.setNumerosVinculados(34);

        casilleroRojo.setUniversalCellCode(43);
        casilleroRojo.setTipoApuesta(color);
        color.setCasilleros(casilleroRojo);

        //Negro
        Casillero casilleroNegro = new Casillero();
        casilleroNegro.setNombre("Negro");
        casilleroNegro.setNumerosVinculados(2);
        casilleroNegro.setNumerosVinculados(6);
        casilleroNegro.setNumerosVinculados(8);
        casilleroNegro.setNumerosVinculados(10);
        casilleroNegro.setNumerosVinculados(11);
        casilleroNegro.setNumerosVinculados(13);
        casilleroNegro.setNumerosVinculados(15);
        casilleroNegro.setNumerosVinculados(17);
        casilleroNegro.setNumerosVinculados(20);
        casilleroNegro.setNumerosVinculados(22);
        casilleroNegro.setNumerosVinculados(24);
        casilleroNegro.setNumerosVinculados(26);
        casilleroNegro.setNumerosVinculados(28);
        casilleroNegro.setNumerosVinculados(29);
        casilleroNegro.setNumerosVinculados(31);
        casilleroNegro.setNumerosVinculados(33);
        casilleroNegro.setNumerosVinculados(35);

        casilleroNegro.setUniversalCellCode(44);
        casilleroNegro.setTipoApuesta(color);
        color.setCasilleros(casilleroNegro);

        //Tipo Efecto
        TipoEfecto aCompleto = new AleatorioCompleto("Aleatorio Completo");
        TipoEfecto aParcial = new AleatorioParcial("Aleatorio Parcial");
        TipoEfecto simulador = new Simulador("Simulador");

        f.agregar(aCompleto);
        f.agregar(aParcial);
        f.agregar(simulador);

    }

}
