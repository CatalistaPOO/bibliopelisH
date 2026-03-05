package com.cursospring.bibliopelis.persistencia.pelicula;

import com.cursospring.bibliopelis.modelo.Genero;
import com.cursospring.bibliopelis.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaDAO extends JpaRepository<Pelicula, Integer> {


    Pelicula findPeliculaByIdPelicula(int idPelicula);
}
