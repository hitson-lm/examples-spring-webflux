package com.example.webflux.reactor.patrones.proxy;

public class TestProxy {

  public static void main(String[] args) {
    // instanciar usuario.
    User user = new User("Pedrito");
    // CASO SUCCESS, donde usario tiene permiso ADMIN y puede visualizar reporte.
    user.grantPermission("ADMIN");

    // Inicializamos el proxy para poder solicitar y visualizar el Reporte financia.
    Financia f = new ProxyDataFinancia(user);
    f.visualizarReport();

    // CASO FAILED: donde "INVITADO" no tiene permiso para visualizar el reporte.
    User user1 = new User("Juan");
    user.grantPermission("INVITADO");
    Financia f1 = new ProxyDataFinancia(user1);
    f1.visualizarReport();


  }


}
