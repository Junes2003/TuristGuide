import com.example.touristGuide.model.TouristAttraction;
import com.example.touristGuide.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private static TouristRepository repository;

    public TouristService(TouristRepository touristRepository) {
        this.repository = touristRepository;
    }

    public List<TouristAttraction> getAllAttractions() {
        return repository.getAllAttractions();
    }

    public TouristAttraction findTouristAttractionByName(String name) {
        return repository.findTouristAttractionByName(name);
    }

    public static TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        return repository.addTouristAttraction(touristAttraction);
    }

    public static TouristAttraction updateTouristAttraction(String name, String newDescription) {
        return repository.updateTouristAttraction(name, newDescription);
    }

    public static TouristAttraction deleteTouristAttraction(String name) {
        return repository.deleteTouristAttraction(name);
    }
}