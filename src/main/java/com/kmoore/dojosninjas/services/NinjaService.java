package com.kmoore.dojosninjas.services;

import com.kmoore.dojosninjas.models.Dojo;
import com.kmoore.dojosninjas.models.Ninja;

import com.kmoore.dojosninjas.repositories.NinjaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<Ninja> getAll() {
        return (List<Ninja>) ninjaRepository.findAll();
    }


}
