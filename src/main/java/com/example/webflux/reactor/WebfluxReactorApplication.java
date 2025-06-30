package com.example.webflux.reactor;

import com.example.webflux.reactor.patrones.EjemploSingleton;
import com.example.webflux.reactor.patrones.ExampleBuilder;
import com.example.webflux.reactor.patrones.factory.Animal;
import com.example.webflux.reactor.patrones.factory.AnimalFactory;
import com.example.webflux.reactor.patrones.factory.Perro;
import com.example.webflux.reactor.patrones.factory.TipoAnimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class WebfluxReactorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxReactorApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		AnimalFactory fabrica = new AnimalFactory();

		// Indicas a fabrica que cree un animal de tipo PERRO.
		Animal perro = fabrica.createAnimal(TipoAnimal.PERRO);
		Animal gato = fabrica.createAnimal(TipoAnimal.GATO);

		System.out.println("Animal perro: "+perro.getSonido());
		System.out.println("Animal gato: "+gato.getSonido());

		/*Flux<String> listName = Flux.just("Luis", "Jesus", "Beto");

		listName.doOnNext(name -> System.out.println(name))
				.subscribe();

		obtenerMono().doOnNext(name -> System.out.println(name)).subscribe();*/

		//mono();
		//flux();
		//fluxMono();
		//Ejercicio_01 ej1 = new Ejercicio_01();
		//ej1.mono();
		//ej1.rangeFlux();
		//ej1.map();
		//ej1.filter();
		//ej1.monoEmpty();
		//ej1.monoError();
		//ej1.fluxMerge();
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
