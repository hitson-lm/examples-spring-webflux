package com.example.webflux.reactor.patrones.proxy;

import java.util.HashSet;
import java.util.Set;

public class User {

  private final String name;
  private final Set<String> permisos;

  public User(String name) {
    this.name = name;
    this.permisos = new HashSet<>();
  }

  public boolean hasPermission(String rol) {
    return permisos.contains(rol);
  }

  public void grantPermission(String rol) {
    permisos.add(rol);
  }


  public String getName() {
    return name;
  }

}
