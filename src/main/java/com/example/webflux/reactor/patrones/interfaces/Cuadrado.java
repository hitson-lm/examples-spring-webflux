package com.example.webflux.reactor.patrones.interfaces;

public class Cuadrado implements Figura,Dibujable{
  private double lado;

  public Cuadrado(double lado){
    this.lado = lado;
  }

  // implementa de la interface Figura.
  @Override
  public double calcularArea() {
    return lado * lado;
  }

  // implementa de otra interface Dibujable.
  @Override
  public void dibujar() {
    System.out.println("Empieza a dibujar la figura Cuadrado...");
  }
}
