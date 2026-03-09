package com.cursospring.bibliopelis.controller;

import com.cursospring.bibliopelis.modelo.Genero;
import com.cursospring.bibliopelis.modelo.Pelicula;
import com.cursospring.bibliopelis.negocio.genero.GeneroServiceImpl;
import com.cursospring.bibliopelis.negocio.pelicula.PeliculaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class PeliculaController {

        private GeneroServiceImpl gs;
        private PeliculaServiceImpl ps;

        public PeliculaController(GeneroServiceImpl gs, PeliculaServiceImpl ps) {
            this.gs = gs;
            this.ps = ps;
        }

        // Cambiado de /movie-detail a /pelicula para coincidir con el HTML
        @GetMapping("/pelicula/{id}")
        public String showMovieDetail(@PathVariable int id, Model model) {
            // Obtenemos la película (mejor manejar si no existe)
            Pelicula pelicula = ps.getPeliculaPorId(id);
            model.addAttribute("pelicula", pelicula);
            return "movie-detail";
        }

    @GetMapping("/new-movie")
    public String createNewPelicula(Model model){
        List<Genero> generos = gs.getGeneros();
        model.addAttribute("generos", generos);
        model.addAttribute("currentYear", IndexController.getYear());
        return "new-movie";
    }

    @PostMapping("/new-movie")
    public String guardarPelicula(Pelicula pelicula, @RequestParam List<Integer> generosIds) {
        Set<Genero> gens = new HashSet<>();
        for (int i = 0; i < generosIds.size(); i++){
            Genero gener = gs.getGeneroPorId(generosIds.get(i));
            gens.add(gener);
        }
        pelicula.setGeneros(gens);
        ps.createPelicula(pelicula);
        return "redirect:/";
    }
    }







