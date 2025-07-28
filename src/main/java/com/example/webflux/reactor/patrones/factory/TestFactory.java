package com.example.webflux.reactor.patrones.factory;

public class TestFactory {

  public static void main(String[] args) {

    //inicializa la instancia de fabrica animal para usar su metodo publico.
    AnimalFactory fabrica = new AnimalFactory();
    System.out.println("Fabrica animal: "+fabrica); // AnimalFactory()

    // Indicas a fabrica que cree un animal de tipo PERRO.
    Animal perro = fabrica.createAnimal(TipoAnimal.PERRO);
    Animal gato = fabrica.createAnimal(TipoAnimal.GATO);

    System.out.println("Animal perro: "+perro.getSonido()); //impl Perro, Gau Gau..!!
    System.out.println("Animal gato: "+gato.getSonido()); //Impl Gato, Miau Miau..!

  }
}
