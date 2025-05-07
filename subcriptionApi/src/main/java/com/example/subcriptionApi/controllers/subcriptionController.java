package com.example.subcriptionApi.controllers;

import com.example.subcriptionApi.models.subcription;
import com.example.subcriptionApi.services.subcriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class subcriptionController {


    @Autowired
    subcriptionService service;


    @GetMapping("/subscriptions")
    public List<subcription> getAllSubcription(){
        return service.getAllSubcription();
    }

    @GetMapping("/subscriptions/{id}")
    public subcription GetProductById(@PathVariable Long id){
        return service.getSubcriptionById(id);

    }

    @PostMapping("/subscriptions")
    public ResponseEntity<subcription> createSubcription(@RequestBody subcription model){
        return ResponseEntity.ok(service.create(model));

    }

    @PutMapping("/subscriptions/{id}")
    public ResponseEntity<subcription> updateSubcription(@RequestBody subcription model){
        return ResponseEntity.ok(service.update(model));

    }


    @DeleteMapping("/subscriptions/{id}")
    public ResponseEntity<Void> deleteSubcription(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }




}
