package com.example.webflux.reactor.patrones.factory;

/**
 * INTERFACE: solo puede haber metodos abstractos y constantes pero solo estaticas y publicas.
 * tambien la interface se considera como una "clase abstracta" y clase padre. No se puede instanciar,
 * son contratos que deben cumplir las sub clases con la implementacion.
 */
public interface Animal {

  // metodo abstracto.
  String getSonido();

}
