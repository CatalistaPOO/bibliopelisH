package com.cursospring.bibliopelis.negocio.pelicula;


import com.cursospring.bibliopelis.modelo.Pelicula;
import com.cursospring.bibliopelis.persistencia.pelicula.PeliculaDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeliculaServiceImpl implements PeliculaService {


    private PeliculaDAO pDao;

    public PeliculaServiceImpl(PeliculaDAO pDao){
        super();
        this.pDao = pDao;
    }


    @Override
    public List<Pelicula> getPeliculas() {
        return pDao.findAll();
    }

    public Pelicula getPeliculaPorId(int idPelicula){
        return pDao.findById(idPelicula).orElse(null);
    }

    @Override
    public void deletePeliculaPorId(int id) {
        pDao.deleteById(id);
    }

    @Override
    public void createPelicula(Pelicula pelicula) {
        pDao.save(pelicula);
    }

    @Override
    public List<Pelicula> getPeliculaPorTituloYPorGeneroId(String titulo, Integer generoId, Integer anyo) {
        return pDao.buscarPorFiltros(titulo, generoId, anyo);
    }


}
