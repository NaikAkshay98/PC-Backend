package com.example.capstone.service;

import com.example.capstone.model.DogOwner;
import com.example.capstone.repository.DogOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DogOwnerService {

    @Autowired
    private DogOwnerRepository dogOwnerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public DogOwner registerDogOwner(DogOwner registrationDto) {
        DogOwner dogOwner = new DogOwner();
        dogOwner.setEmail(registrationDto.getEmail());
        dogOwner.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        dogOwner.setFirstName(registrationDto.getFirstName());
        dogOwner.setLastName(registrationDto.getLastName());
        dogOwner.setPhone(registrationDto.getPhone());
        dogOwner.setPhoto(registrationDto.getPhoto());
        // Set other properties as necessary

        return dogOwnerRepository.save(dogOwner);
    }
    public DogOwner authenticateDogOwner(DogOwner loginDto) throws Exception {
        DogOwner dogOwner = dogOwnerRepository.findByEmail(loginDto.getEmail())
                .filter(owner -> passwordEncoder.matches(loginDto.getPassword(), owner.getPassword()))
                .orElseThrow(() -> new Exception("Invalid credentials"));
        
        // Nullify the password before sending it back for security reasons
        dogOwner.setPassword(null);
        
        return dogOwner;
    }

    
}
