package com.kmoore.dojosninjas.repositories;


import com.kmoore.dojosninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
}
