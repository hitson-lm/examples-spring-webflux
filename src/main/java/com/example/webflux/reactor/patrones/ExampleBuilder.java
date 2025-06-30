package com.example.webflux.reactor.patrones;

public class ExampleBuilder {
  private String name;
  private int age;

  public ExampleBuilder (Builder builder) {
    this.name = builder.name;
    this.age = builder.age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "ExampleBuilder{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }


  public static class Builder {
    private String name;
    private int age;

    public ExampleBuilder.Builder name(String nombre) {
      this.name = nombre;
      return this;
    }

    public ExampleBuilder.Builder age (int anio) {
      this.age = anio;
      return this;
    }

    public ExampleBuilder build() {
      return new ExampleBuilder(this);
    }

  }


}
