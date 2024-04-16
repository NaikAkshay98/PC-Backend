package com.example.capstone.controller;

import com.example.capstone.model.DogOwner;
import com.example.capstone.service.DogOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/dogowners")
public class DogOwnerController {

    @Autowired
    private DogOwnerService dogOwnerService;

    @PostMapping("/register")
    public ResponseEntity<?> registerDogOwner(@RequestBody DogOwner registrationDto) {
        try {
            DogOwner dogOwner = dogOwnerService.registerDogOwner(registrationDto);
            return new ResponseEntity<>(dogOwner, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register dog owner", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginDogOwner(@RequestBody DogOwner loginDto) {
        try {
            DogOwner authenticatedDogOwner = dogOwnerService.authenticateDogOwner(loginDto);
            return ResponseEntity.ok(authenticatedDogOwner);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<?> getDogOwnerProfile(@PathVariable String email) {
        try {
            DogOwner dogOwner = dogOwnerService.getDogOwnerByEmail(email);
            // Remember to nullify the password before sending the dog owner object
            dogOwner.setPassword(null);
            return ResponseEntity.ok(dogOwner);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    

}
