package com.example.webflux.reactor.patrones.strategy;

public class EstrategiaImpuestoAR implements EstrategiaImpuesto{

  @Override
  public double calcular(double ingreso) {
    return ingreso * 0.35;
  }
}
