package com.cursospring.bibliopelis.persistencia.genero;

import com.cursospring.bibliopelis.modelo.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroDAO extends JpaRepository<Genero, Integer>{



}
