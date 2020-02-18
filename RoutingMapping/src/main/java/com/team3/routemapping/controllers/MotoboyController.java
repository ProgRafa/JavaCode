package com.team3.routemapping.controllers;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class MotoboyController {
    @GetMapping("/mapfood/restaurants/{restaurantID}/motoboy")
    public ResponseEntity<?> motoboyRequest(@PathVariable("restaurantID") String id){
        try {
            return ResponseEntity.ok("ok");//ResponseEntity.ok(request.getResponse());
        }catch (EmptyResultDataAccessException empty){
            return ResponseEntity.status(400).body("Nenhum motoboy próximo.");
        } catch (Exception error){
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }

    @GetMapping("/mapfood/route")
    public ResponseEntity<?> getRoute(){
        try{
            return null;
        }catch (Exception error){
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }
}
