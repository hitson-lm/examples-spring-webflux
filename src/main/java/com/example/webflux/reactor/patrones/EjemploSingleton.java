package com.example.webflux.reactor.patrones;

import com.example.webflux.reactor.Person;
import lombok.ToString;


/**
 * Singleton: No puedes instanciar o crear objeto directamente en otra Clase ya que su contructor es privado.
 * debes usar su metodo statico público "getInstance" para crear una unica instancia.
 */
@ToString
public class EjemploSingleton {

  private static EjemploSingleton instance; //static(global): permite que la instancia Singleton se compartida por la aplicacion.
  private final String name;
  private final Person person; // final(inmutable): no puede ser modificado despues de ser inicializado.

  //constructor: inicializa y construye valores a los atributos de la clase.
  private EjemploSingleton() {
    // contructor privado para evitar instanciacion externa.
    this.name = "Singleton instance";
    this.person = Person.builder()
        .name("Pedrito")
        .lastName("Perez Rojas")
        .build();
  }

  /**
   * Metodo publico para obtener la instancia de la Clase EjemploSingleton.
   * @return
   */
  public static EjemploSingleton getInstance() {
    //System.out.println("Es null?: " + (instance == null)); // true
    if (instance == null) { // El objeto inicia null
      instance = new EjemploSingleton();  // inicia la instancia con el metodo constructor.
    }
    return instance; // retorna la instancia unica.
  }

  /**
   * Metodo publico que retorna una instancia unica de tipo String.
   * @return
   */
  public String getName() {
    return this.name;
  }

  /**
   * Metodo publico que retorna una instancia unica de Objecto Person.
   * @return
   */
  public Person getPerson() {
    return this.person;
  }


}
