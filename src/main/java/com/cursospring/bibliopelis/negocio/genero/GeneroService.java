package com.cursospring.bibliopelis.negocio.genero;

import com.cursospring.bibliopelis.modelo.Genero;

import java.util.List;

public interface GeneroService {

    public List<Genero> getGeneros();
    public void createGenero(Genero genero);
    public Genero getGeneroPorId(int id);
    public void deleteGeneroPorId(int id);
}
