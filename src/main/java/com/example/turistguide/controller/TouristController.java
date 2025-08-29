package com.example.turistguide.controller;


import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService tourist;

    public TouristController(TouristService touristService) {
        this.tourist = touristService;
    }

    @GetMapping()
    public ResponseEntity<List<TouristAttraction>> getTouristAttraction() {
        List<TouristAttraction> attraction = TouristService.getTouristAttraction();
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @GetMapping({"name"})
    public ResponseEntity<List<TouristAttraction>> getTouristAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.findTouristAttractionByName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

    @PostMapping("delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@RequestBody String name){
        TouristAttraction deletedTouristAttraction = touristService.deleteTouristAttraction(name);
        return new ResponseEntity<>(deletedTouristAttraction, HttpStatus.CREATED);
    }
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction attraction){
        TouristAttraction newTouristAttraction = touristService.addTouristAttraction(attraction);
        return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction attraction) {
        TouristAttraction updatedTouristAttraction = touristService.updateTouristAttraction(attraction.getName(), attraction.getDescription());

       if (attraction != null){
           return new ResponseEntity<>(newTouristAttraction, HttpStatus.CREATED);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);    }
}



