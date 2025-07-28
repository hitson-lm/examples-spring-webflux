package com.example.webflux.reactor.patrones.interfaces;

public class TestInterface {

  public static void main(String[] args) {

    /*Figura fig = new Cuadrado(2);
    Figura fig2 = new Circulo(5);

    System.out.println("Area del cuadrado es: "+ fig.calcularArea());
    System.out.println("Area del circulo es: "+ fig2.calcularArea());

    Rotable fig3 = new Circulo(5);
    fig3.rotar();*/

    Circulo fig = new Circulo(2);
    fig.rotar();
    fig.dibujar();
    System.out.println("Area del circulo: "+ fig.calcularArea());
    System.out.println("-----------------------------");

    Cuadrado fig1 = new Cuadrado(3);
    fig1.dibujar();
    System.out.println("Area del cuadrado: "+fig1.calcularArea());


  }
}
