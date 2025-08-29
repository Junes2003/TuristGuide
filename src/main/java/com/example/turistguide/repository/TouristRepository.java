package com.example.turistguide.repository;


import com.example.turistguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        touristAttractions.add(new TouristAttraction("Den lille havfrue", "Berømt statue i hele verden"));
        touristAttractions.add(new TouristAttraction("Runde Tårn", "Kendt turistattraktion med god udsigt"));
        touristAttractions.add(new TouristAttraction("Bella Sky", "Hotel på Amager"));
        touristAttractions.add(new TouristAttraction("Gå Spis", "Junes-Elsayed"));
        touristAttractions.add(new TouristAttraction("Parken", "Største stadion i Danmark"));
    }

    public TouristAttraction addTouristAttraction(TouristAttraction attraction) {
        touristAttractions.add(attraction);
        return attraction;
    }

    public TouristAttraction updateTouristAttraction(String name, String description) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attraction.setDescription(description);
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction deleteTouristAttraction(String name) {
        TouristAttraction attractionToDelete = findTouristAttractionByName(name);
        if (attractionToDelete != null) {
            touristAttractions.remove(attractionToDelete);
            return attractionToDelete;
        }
        return null;
    }

    public List<TouristAttraction> getAllAttractions() {
        return new ArrayList<>(touristAttractions);
    }

    public TouristAttraction findTouristAttractionByName(String name) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }
}
