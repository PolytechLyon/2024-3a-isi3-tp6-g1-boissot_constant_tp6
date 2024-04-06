package fr.polytech.sim.cycling;

import java.util.Iterator;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerFactory;
import fr.polytech.sim.utils.Context;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    private final Logger logger = LoggerFactory.createLogger("BikeSimulator");

    public void run() {
        Iterator<Bike> bikes = Context.injectAll(Bike.class);
        while (bikes.hasNext()) { 
            Bike bike = bikes.next();
            this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
            this.logger.log("Bike's mass %.2f Kg.", bike.getMass());
        }
    }
}
