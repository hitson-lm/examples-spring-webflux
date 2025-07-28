package com.example.webflux.reactor.patrones.observer;

public class TestObserver {

  public static void main(String[] args) {

    // Observer: es el observador que escucha y reacciona una vez es notificado por el Sujeto (Observable)
    // Observable: es el sujeto que administra los "Observer" y tambien notifica algun evento.

    // Insatancia del observable CanalYoutube.
    CanalYoutube observable = new CanalYoutube();

    //se agrega los observers(Suscriptores) que seran notificados mas adelante.
    observable.agregarObserver(new Suscriptor1Observer());
    observable.agregarObserver(new Suscriptor2Observer());

    //se notifica a los observers(suscriptores)
    observable.notificarObservers();
    

  }
}
