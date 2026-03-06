package com.cursospring.bibliopelis.persistencia.pelicula;

import com.cursospring.bibliopelis.modelo.Genero;
import com.cursospring.bibliopelis.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaDAO extends JpaRepository<Pelicula, Integer> {


    List<Pelicula> findPeliculaByIdPelicula(int idPelicula);

    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN p.generos g " +
            "WHERE (:titulo IS NULL OR LOWER(p.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))) " +
            "AND (:generoId IS NULL OR g.idGenero = :generoId)")
    List<Pelicula> buscarPorFiltros(@Param("titulo") String titulo, @Param("generoId") Integer generoId);

}
