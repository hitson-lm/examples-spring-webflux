package com.example.webflux.reactor.patrones.observer;

/**
 * La clase Suscriptor1Observer es un obervador
 * Observer: es el observador que escucha y reacciona una vez es notificado por el Sujeto (Observable) -> CanalYoutube
 */
public class Suscriptor1Observer implements Observer{

  @Override
  public void escuchar() {
    System.out.println("Suscriptor 1, se ha subido un nuevo video en el canal de youtube HLM");
  }

}
