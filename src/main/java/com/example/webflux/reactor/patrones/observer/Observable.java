package com.example.webflux.reactor.patrones.observer;

public interface Observable {

  void agregarObserver(Observer o);

  void notificarObservers();

}
