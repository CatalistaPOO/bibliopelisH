package com.cursospring.bibliopelis.negocio.pelicula;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PeliculaServiceImplTest {

    @Autowired
    PeliculaServiceImpl ps;

    @Test
    void getPeliculas() {
        ps.getPeliculas();
    }

//    @Test
//    void getPeliculaPorId() {
//    }
//
//    @Test
//    void deletePeliculaPorId() {
//    }
//
//    @Test
//    void createPelicula() {
//    }
}