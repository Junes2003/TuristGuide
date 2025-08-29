package com.example.turistguide.repository;
import com.example.turistguide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        attractions.add(new TouristAttraction("Den lille havfrue ", "Berømt statue i hele verden"));
        attractions.add(new TouristAttraction("Runde Tårn", "Kendt turistattraktion med god udsigt"));
        attractions.add(new TouristAttraction("Bella Sky", "Hotel på Amager"));
        attractions.add(new TouristAttraction("Louisiana", "Museum "));
        attractions.add(new TouristAttraction("Parken", "Største stadion i Danmark "));
    }

    public void addTouristAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public TouristAttraction updateTouristAttraction(String name, String description) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attraction.setName(name);
                attraction.setDescription(description);
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction deleteTouristAttraction(String name) {
        TouristAttraction attractionToDelete = null;
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attractionToDelete = attraction;
            }
        }
        if (attractionToDelete != null) {
            attractions.remove(attractionToDelete);
            return attractionToDelete;
        }
        return null;
    }


    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }
}
   // public TouristAttraction findTouristAttractionByName(String name) {
   // }
//}
