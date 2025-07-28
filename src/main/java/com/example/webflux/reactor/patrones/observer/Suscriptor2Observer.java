package com.example.webflux.reactor.patrones.observer;

/**
 * La clase Suscriptor2Observer es un obervador.
 * Observer: es el observador que escucha y reacciona una vez es notificado por el Sujeto (Observable) -> CanalYoutube
 */
public class Suscriptor2Observer implements Observer{

  @Override
  public void escuchar() {
    System.out.println("Suscriptor 2, se ha subido un nuevo video en el canal de youtube HLM");
  }

}
