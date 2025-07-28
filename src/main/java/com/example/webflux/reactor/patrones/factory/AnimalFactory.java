package com.example.webflux.reactor.patrones.factory;

import lombok.ToString;

/**
 * Clase que fabrica y crea Animal.
 */
@ToString
public class AnimalFactory {

  /**
   * Metodo que crea Animal a partir de parametro TipoAnimal(PERO,GATO,GALLINA)
   * @param tipoAnimal
   * @return Animal
   */
  public Animal createAnimal(TipoAnimal tipoAnimal) {
    switch (tipoAnimal) {
      case PERRO:
        return new Perro();
      case GATO:
        return new Gato();
      case GALLINA:
        return new Gallina();
      default:
        return null;
    }

  }

}
