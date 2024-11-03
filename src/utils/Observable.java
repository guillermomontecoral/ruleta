/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import utils.Observador.Evento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author digregor
 */
public abstract class Observable {

    private List<Observador> subscriptores;

    public Observable() {
        subscriptores = new ArrayList();
    }

    public void subscribir(Observador observador) {
        subscriptores.add(observador);
    }

    public void desubscribir(Observador observador) {
        subscriptores.remove(observador);
    }

    public void notificar(Evento evento) {
        subscriptores.forEach(s -> s.actualizar(this, evento));
    }
}
