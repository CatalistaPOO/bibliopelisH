package com.cursospring.bibliopelis;

import com.cursospring.bibliopelis.modelo.Genero;
import com.cursospring.bibliopelis.modelo.Pelicula;
import com.cursospring.bibliopelis.negocio.genero.GeneroServiceImpl;
import com.cursospring.bibliopelis.negocio.pelicula.PeliculaServiceImpl;
import com.cursospring.bibliopelis.persistencia.pelicula.PeliculaDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Set;

@SpringBootApplication
public class BibliopelisApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BibliopelisApplication.class, args);

		// 2. Pedimos el Bean del servicio al contenedor de Spring
		PeliculaServiceImpl ps = context.getBean(PeliculaServiceImpl.class);
		GeneroServiceImpl gs = context.getBean(GeneroServiceImpl.class);

		Pelicula new1 = ps.getPeliculaPorId(1);

// 2. Obtienes la colección y añades el nuevo género
		Set<Genero> generosNew = new1.getGeneros();
		generosNew.add(gs.getGeneroPorId(3));

// 3. Vuelves a asignar el Set (opcional si es el mismo objeto, pero recomendable)
		new1.setGeneros(generosNew);

// 4. ¡VITAL! Persistir el cambio en la base de datos
		ps.createPelicula(new1);

//		ps.getPeliculaPorId(3).setTitulo("Curso de IMPLANTACIÓN Y GESTIÓN DE ELEMENTOS");


	}

}
