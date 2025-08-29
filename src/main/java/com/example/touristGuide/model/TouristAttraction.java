package com.example.touristGuide.model;

public class TouristAttraction {
    private String name;
    private String description;

    public TouristAttraction (String name, String description) {
        this.name = name;
        this.description = description;
    }

//    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
//        return touristAttraction;
//    }
    // ER OVENSTÅENDE OVERHOVEDET NØDVENDIG?

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TouristAttraction add(TouristAttraction attraction) {

        return attraction;
    }
}

