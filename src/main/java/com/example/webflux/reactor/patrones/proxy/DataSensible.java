package com.example.webflux.reactor.patrones.proxy;

/**
 * Clase encargado de mostrar el reporte, una vez pasado la capa de Proxy -> ProxyDataFinancia
 * Constructor protegido, para que pueda ser accedido unicamente de proxy.
 */
public class DataSensible implements Financia {

  DataSensible() {}

  @Override
  public void visualizarReport() {
    System.out.println("Mostrando reporte financiero detallado. [DataSensible]");
  }
}
