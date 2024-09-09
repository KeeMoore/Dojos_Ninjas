package com.kmoore.dojosninjas.services;
import com.kmoore.dojosninjas.models.Dojo;
import com.kmoore.dojosninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> getAll() {
        return (List<Dojo>) dojoRepository.findAll();
    }

    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    public Dojo getById(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }

    public Object findAllDojos() {
        return null;
    }
}
