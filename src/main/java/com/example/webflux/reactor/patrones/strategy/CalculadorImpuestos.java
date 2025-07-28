package com.example.webflux.reactor.patrones.strategy;

/**
 * Clase CalculadorImpuestos, delega responsabilidades a las clases que implementan del interface strategy
 * "EstrategiaImpuesto"
 * recibe el ingreso bruto y muestra el resultado.
 */
public class CalculadorImpuestos {

  private final EstrategiaImpuesto estrategiaImpuesto;

  // permite cambiar la estrategia en tiempo de ejecucion.
  public CalculadorImpuestos(EstrategiaImpuesto estrategiaImpuesto) {
    this.estrategiaImpuesto = estrategiaImpuesto;
  }

  public double calcular(double ingreso) {
    return estrategiaImpuesto.calcular(ingreso);
  }
  // Ventajas
  // - Facilita la extension de nuevos algoritmos sin modificar el codigo existente.
  // - Reduce el uso de condicionales complejos.
  // - Promueve el principio de responsabilidad unica.
}
