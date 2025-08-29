package com.example.turistguide.service;

import com.example.turistguide.model.TouristAttraction;
import com.example.turistguide.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return repository.getAllAttractions();
    }

    public TouristAttraction findTouristAttractionByName(String name) {
        return repository.findTouristAttractionByName(name);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        return repository.addTouristAttraction(touristAttraction);
    }

    public TouristAttraction updateTouristAttraction(String name, String description) {
        return repository.updateTouristAttraction(name, description);
    }

    public boolean deleteTouristAttraction(String name) {
        return repository.deleteTouristAttraction(name);
    }
}