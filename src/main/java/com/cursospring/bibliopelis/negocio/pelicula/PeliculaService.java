package com.cursospring.bibliopelis.negocio.pelicula;


import com.cursospring.bibliopelis.modelo.Pelicula;

import java.util.List;

public interface PeliculaService {

    public List<Pelicula> getPeliculas();

    public Pelicula getPeliculaPorId(int id);

    public void deletePeliculaPorId(int id);

    public void createPelicula(Pelicula pelicula);




}
