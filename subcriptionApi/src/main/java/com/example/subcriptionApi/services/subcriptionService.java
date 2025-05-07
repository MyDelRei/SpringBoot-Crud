package com.example.subcriptionApi.services;

import com.example.subcriptionApi.models.subcription;
import com.example.subcriptionApi.repository.subcriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class subcriptionService {


    @Autowired
    subcriptionRepository repo;

    // read all subcription
    public List<subcription> getAllSubcription(){
        return repo.findAll();
    }


    // get that subcription by id
    public subcription getSubcriptionById(Long id){
        return repo.findById(id).orElse(new subcription());
    }

    // create new subcription
    public subcription create(subcription model){
         return repo.save(model);

    }

    //update subcription
    public subcription update(subcription model){
        return repo.save(model);

    }


    public void delete(Long id){
         repo.deleteById(id);
    }






}
