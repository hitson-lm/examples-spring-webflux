package com.example.webflux.reactor.patrones.interfaces;

public class Circulo implements Rotable,Figura,Dibujable {

  private double radio;

  public Circulo(double radio) {
    this.radio = radio;
  }

  // implementa de otra interface Rotable.
  @Override
  public void rotar() {
    System.out.println("El Circulo empieza rotar...!!");
  }

  // implementa de otra interface Dibujable.
  @Override
  public void dibujar() {
    System.out.println("Se empieza a dibujar la figura Circulo...");
  }

  // implementa de interface Figura.
  @Override
  public double calcularArea() {
    double pi = 3.14;
    return pi * radio * radio;
  }

}
