package com.example.webflux.reactor.patrones.factory;

public class Gato implements Animal{

  @Override
  public String getSonido() {
    return "Impl Gato, Miau Miau..!";
  }
}
