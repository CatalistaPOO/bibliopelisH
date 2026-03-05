package com.cursospring.bibliopelis.controller;

import com.cursospring.bibliopelis.modelo.Pelicula;
import com.cursospring.bibliopelis.negocio.genero.GeneroServiceImpl;
import com.cursospring.bibliopelis.negocio.pelicula.PeliculaService;
import com.cursospring.bibliopelis.negocio.pelicula.PeliculaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    private GeneroServiceImpl gs;
    private PeliculaServiceImpl ps;

    public IndexController(PeliculaServiceImpl ps, GeneroServiceImpl gs) {
        this.gs = gs;
        this.ps = ps;
    }

    @GetMapping("/")
    public String getIndexPage(Model model){
        model.addAttribute("generos", gs.getGeneros());
        model.addAttribute("peliculas", ps.getPeliculas());
        return "index";
    }


    @GetMapping("/pelicula/{id}")
    public String getDetallePelicula(@PathVariable int id, Model model) {
        // Asumiendo que tienes este método en tu PeliculaService
        Pelicula peli = ps.getPeliculaPorId(id);
        model.addAttribute("pelicula", peli);
        return "movie-detail"; // Nombre de tu archivo HTML de detalle
    }


}
