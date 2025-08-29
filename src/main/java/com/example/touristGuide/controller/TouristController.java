package com.example.touristGuide.controller;


import com.example.touristGuide.model.TouristAttraction;
import com.example.touristGuide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController (TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getTouristAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getTouristAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.findTouristAttractionByName(name);
        if (attraction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction attraction){
        TouristAttraction newTouristAttraction = TouristService.addTouristAttraction(attraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }

    @PostMapping("/update/{attractionName}")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@PathVariable String attractionName, @RequestBody String newDescription) {
        TouristAttraction updatedTouristAttraction = TouristService.updateTouristAttraction(attractionName, newDescription);

        if (updatedTouristAttraction != null) {
            return new ResponseEntity<>(updatedTouristAttraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping ("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name) {
        TouristAttraction deletedTouristAttraction = TouristService.deleteTouristAttraction(name);
        if (deletedTouristAttraction == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedTouristAttraction, HttpStatus.OK);
    }
}








