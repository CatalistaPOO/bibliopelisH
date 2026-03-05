package com.cursospring.bibliopelis.modelo;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pelicula")
    private int idPelicula;
    private String titulo;
    private int anyo;
    @Column(name="url_video")
    private String urlVideo;
    @ManyToMany
    @JoinTable(name = "peliculas_generos",
            joinColumns = @JoinColumn(name = "idPelicula"),
            inverseJoinColumns = @JoinColumn(name = "idGenero"))
    private Set<Genero> generos;

    public Pelicula(String titulo, int anyo, Set<Genero> generos) {
        this.titulo = titulo;
        this.anyo = anyo;
        this.generos = generos;
    }

    public Pelicula() {
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public String toString() {
        return "Pelicula(" +
                "idPeli=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", anyo=" + anyo +
                ", generos=" + generos +
                ')';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return idPelicula == pelicula.idPelicula && Objects.equals(urlVideo, pelicula.urlVideo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPelicula);
    }


}
