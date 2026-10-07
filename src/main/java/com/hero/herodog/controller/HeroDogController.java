package com.hero.herodog.controller;

import com.hero.herodog.model.HeroDog;
import com.hero.herodog.repository.HeroDogRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/herodogs")
public class HeroDogController {

        private final HeroDogRepository repository;

        public HeroDogController(HeroDogRepository repository) {
            this.repository = repository;
        }

        @GetMapping
        public List<HeroDog> getAllDogs() {

            return repository.findAll();
        }

        @PostMapping
        public HeroDog createDog(@RequestBody HeroDog dog) {

            return repository.save(dog);
        }

        @GetMapping("/{id}")
        public HeroDog getDog(@PathVariable Long id) {

            return repository.findById(id).orElse(null);
        }

        @PutMapping("/{id}")
        public HeroDog updateDog(@PathVariable Long id,
                                 @RequestBody HeroDog updatedDog) {
            HeroDog dog = repository.findById(id).orElse(null);
            if (dog == null) return null;

            dog.setName(updatedDog.getName());
            dog.setBreed(updatedDog.getBreed());
            dog.setAge(updatedDog.getAge());
            dog.setYearsDiabetic(updatedDog.getYearsDiabetic());
            dog.setHeroMessage(updatedDog.getHeroMessage());
            dog.setPhotoUrl(updatedDog.getPhotoUrl());

            return repository.save(dog);
        }

        @DeleteMapping("/{id}")
        public void deleteDog(@PathVariable Long id) {
            repository.deleteById(id);
        }
    }





