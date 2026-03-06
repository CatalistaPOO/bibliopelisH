package com.cursospring.bibliopelis.modelo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_genero")
    private int idGenero;
    private String genero;
    @ManyToMany(mappedBy = "generos")
    private Set<Pelicula> peliculas;

    public Genero() {
    }

    public Genero(String genero) {
        this.genero = genero;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Set<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return idGenero == genero.idGenero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idGenero);
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", genero='" + genero + '\'' +
                '}';
    }
}
