package fr.polytech.sim.transport;
import fr.polytech.sim.cycling.SimpleBike;

public class TagAlongBike extends SimpleBike{

    public TagAlongBike() {
        components.add(new SimpleBike());
    }

    public TagAlongBike(SimpleBike b) {
        components.add(b);
    }
    
    
    
}
