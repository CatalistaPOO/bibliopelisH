package com.cursospring.bibliopelis.controller;

import com.cursospring.bibliopelis.modelo.Genero;
import com.cursospring.bibliopelis.modelo.Pelicula;
import com.cursospring.bibliopelis.negocio.genero.GeneroServiceImpl;
import com.cursospring.bibliopelis.negocio.pelicula.PeliculaService;
import com.cursospring.bibliopelis.negocio.pelicula.PeliculaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class IndexController {

    private GeneroServiceImpl gs;
    private PeliculaServiceImpl ps;

    public IndexController(PeliculaServiceImpl ps, GeneroServiceImpl gs) {
        this.gs = gs;
        this.ps = ps;
    }

    @GetMapping("/")
    public String getIndexPage(@RequestParam(required = false) String titulo,
                               @RequestParam(required = false) Integer generoId,
                               @RequestParam(required = false) Integer anyo,
                               Model model){
        int currentYear = getYear();
        model.addAttribute("currentYear", currentYear);
        model.addAttribute("generos", gs.getGeneros());

        if((titulo != null && !titulo.isEmpty()) || generoId != null || anyo != null){
            model.addAttribute("peliculas", ps.getPeliculaPorTituloYPorGeneroId(titulo, generoId, anyo));
            model.addAttribute("titulo", titulo);
            model.addAttribute("generoId", generoId);
            model.addAttribute("anyo", anyo);
        }else {
            model.addAttribute("peliculas", ps.getPeliculas());
        }
        return "index";
    }

//
//    @GetMapping("/pelicula/{id}")
//    public String getDetallePelicula(@PathVariable int id, Model model) {
//        // Asumiendo que tienes este método en tu PeliculaService
//        Pelicula peli = ps.getPeliculaPorId(id);
//        model.addAttribute("pelicula", peli);
//        return "movie-detail"; // Nombre de tu archivo HTML de detalle
//    }
//
//    @GetMapping("/new-movie")
//    public String createNewPelicula(Model model){
//        List<Genero> generos = gs.getGeneros();
//        model.addAttribute("generos", generos);
//        return "new-movie";
//    }
//
//    @PostMapping("/new-movie")
//    public String guardarPelicula(Pelicula pelicula, @RequestParam List<Integer> generosIds) {
//        Set<Genero> gens = new HashSet<>();
//        for (int i = 0; i < generosIds.size(); i++){
//            Genero gener = gs.getGeneroPorId(generosIds.get(i));
//            gens.add(gener);
//        }
//        pelicula.setGeneros(gens);
//        ps.createPelicula(pelicula);
//        return "redirect:/";
//    }

    static public int getYear(){
        int currentYear = Year.now().getValue();
        return currentYear;
    }


}
