package com.example.webflux.reactor.patrones.proxy;


import java.time.LocalDate;

/**
 * Clase proxy puerta de entrada o intermediario, para poder visualizar el reporte segun permiso admitido.
 * proxy -> Controlador de acceso para restringuir algunos recursos.
 */
public class ProxyDataFinancia implements Financia{

  private final DataSensible dataSensible;
  private final User user;

  public ProxyDataFinancia(User user) {
    this.user = user;
    this.dataSensible = new DataSensible();
  }

  @Override
  public void visualizarReport() {
    // usuario tienen permiso "ADMIN"?
    if (user.hasPermission("ADMIN")) {
      // Brinda informe Financiera DataSensible.
      dataSensible.visualizarReport();
      System.out.println("Acceso registrado para el usuario: "+user.getName()+" el "+ LocalDate.now()+ " [ProxyDataFinancia]");
    } else {
      System.out.println("Acceso denegado. No tiene permisos para ver este reporte.");
    }

  }

}
