package com.example.capstone.controller;
import com.example.capstone.repository.CaretakerRepository;
import com.example.capstone.model.Caretaker;
import com.example.capstone.service.CaretakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/caretakers")
public class CaretakerController {

    @Autowired
    private CaretakerRepository caretakerRepository;

    private CaretakerService caretakerService;

    @GetMapping("/all")
    public ResponseEntity<List<Caretaker>> getAllCaretakers() {
        List<Caretaker> caretakers = caretakerRepository.findAll();
        return ResponseEntity.ok(caretakers);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCaretaker(@RequestBody Caretaker registrationDto) {
        try {
            Caretaker caretaker = caretakerService.registerCaretaker(registrationDto);
            return new ResponseEntity<>(caretaker, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register caretaker", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCaretaker(@RequestBody Caretaker loginDto) {
        try {
            Caretaker authenticatedCaretaker = caretakerService.authenticateCaretaker(loginDto);
            return ResponseEntity.ok(authenticatedCaretaker);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }
}
