package com.example.webflux.reactor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebfluxReactorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxReactorApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		/*Flux<String> listName = Flux.just("Luis", "Jesus", "Beto");

		listName.doOnNext(name -> System.out.println(name))
				.subscribe();

		obtenerMono().doOnNext(name -> System.out.println(name)).subscribe();*/

		//mono();
		//flux();
		//fluxMono();
		Ejercicio_01 ej1 = new Ejercicio_01();
		//ej1.mono();
		//ej1.rangeFlux();
		//ej1.map();
		//ej1.filter();
		//ej1.monoEmpty();
		//ej1.monoError();
		ej1.fluxFlatMap();
	}

	public void mono() {
		Mono.just(new Person("Hitson", "Lapa"))
				.subscribe(p -> System.out.println(p.toString()));
	}

	public void flux() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Jesus", "Lopez"));
		persons.add(new Person("Carlos", "Rojas"));
		persons.add(new Person("Luis", "Perez"));

		Flux.fromIterable(persons)
				.subscribe(p -> System.out.println(p.toString()));
	}

	public void fluxMono() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Jesus", "Lopez"));
		persons.add(new Person("Carlos", "Rojas"));
		persons.add(new Person("Luis", "Perez"));

		Flux.fromIterable(persons)
				.collectList()
				.subscribe(list -> System.out.println(list.toString()));
	}

}
