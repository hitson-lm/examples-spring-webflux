package com.example.webflux.reactor.patrones.observer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase "CanalYoutube" es el sujeto que administra los "Observer" y tambien notifica algun evento.
 */
public class CanalYoutube implements Observable {

  // Collections para agregar a los Observer.
  Set<Observer> observersSet = new HashSet<>();

  @Override
  public void agregarObserver(Observer o) {
    observersSet.add(o);
  }

  @Override
  public void notificarObservers() {

    for (Observer observador : observersSet) {
      observador.escuchar();
    }
  }

}
