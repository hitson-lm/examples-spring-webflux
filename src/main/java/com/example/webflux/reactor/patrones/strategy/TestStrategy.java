package com.example.webflux.reactor.patrones.strategy;

public class TestStrategy {

  public static void main(String[] args) {

    //A partir del constructor se inicializa la estrategia.
    // "EstrategiaImpuesto" -> (EstrategiaImpuestoPE, EstrategiaImpuestoAR, EstrategiaImpuestoMX)
    CalculadorImpuestos imp1 = new CalculadorImpuestos(new EstrategiaImpuestoPE());
    CalculadorImpuestos imp2 = new CalculadorImpuestos(new EstrategiaImpuestoAR());
    CalculadorImpuestos imp3 = new CalculadorImpuestos(new EstrategiaImpuestoMX());

    // calcula el impuesto por pais.
    double impPeru = imp1.calcular(100);
    double impArg = imp2.calcular(100);
    double impMex = imp3.calcular(100);

    System.out.println("El impuesto peru es: "+impPeru);
    System.out.println("El impuesto argentina es: "+impArg);
    System.out.println("El impuesto mexico es: "+impMex);

  }
}
