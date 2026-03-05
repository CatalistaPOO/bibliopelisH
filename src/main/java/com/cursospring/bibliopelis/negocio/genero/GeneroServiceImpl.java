package com.cursospring.bibliopelis.negocio.genero;

import com.cursospring.bibliopelis.modelo.Genero;
import com.cursospring.bibliopelis.persistencia.genero.GeneroDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService{


    private final GeneroDAO gDao;

    public GeneroServiceImpl(GeneroDAO gDao){
        super();
        this.gDao = gDao;
    }


    @Override
    public List<Genero> getGeneros() {
        return gDao.findAll();
    }

    @Override
    public void createGenero(Genero genero) {
        gDao.save(genero);
    }

    @Override
    public Genero getGeneroPorId(int idGenero) {
        return gDao.findById(idGenero).get();
    }

    @Override
    public void deleteGeneroPorId(int id) {
        gDao.deleteById(id);
    }
}
