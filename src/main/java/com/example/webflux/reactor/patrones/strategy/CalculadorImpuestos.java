package com.example.webflux.reactor.patrones.strategy;

/**
 * Clase CalculadorImpuestos, delega responsabilidades a las clases que implementan del interface EstrategiaImpuesto
 * recibe el ingreso bruto y muestra el resultado. Cada
 */
public class CalculadorImpuestos {

  private final EstrategiaImpuesto estrategiaImpuesto;

  public CalculadorImpuestos(EstrategiaImpuesto estrategiaImpuesto) {
    this.estrategiaImpuesto = estrategiaImpuesto;
  }

  public double calcular(double ingreso) {
    return estrategiaImpuesto.calcular(ingreso);
  }

}
