import java.util.HashMap;
import java.util.Map;

class Car {
    private static final double CARBON_EMISSION_PER_PERSON = 1480; //emissions per person in grams for a car traveling a certain distance

    public double getCarbonEmission() {
        return CARBON_EMISSION_PER_PERSON; //returns the carbon emission for a single person in the car.
    }
}

class GondolaSystem {
    private Map<String, Car> cars; //store cars with their owners (using a person's name as the key).
    private double totalCarbonEmission; //keeps track of the total carbon emissions in the system

    public GondolaSystem() {
        this.cars = new HashMap<>();
        this.totalCarbonEmission = 0.0;
    }

    public void addCar(String owner) { //Adds a car to the system for a given owner.
        Car car = new Car();
        cars.put(owner, car);
        totalCarbonEmission += car.getCarbonEmission(); //Updates the total carbon emissions
    }

    public void useGondola(String owner) { //Simulates a person using the gondola
        if (cars.containsKey(owner)) { //Checks if the person (car owner) has a car in the system
            Car car = cars.get(owner);
            System.out.println(owner + " used the gondola. Carbon emission reduced by " + car.getCarbonEmission());
            totalCarbonEmission -= car.getCarbonEmission();
            cars.remove(owner);
            System.out.println("Total Carbon Emission: " + totalCarbonEmission);
        } else {
            System.out.println(owner + " does not have a car in the system.");
        }
    }

    public double getTotalCarbonEmission() {
        return totalCarbonEmission; //Returns the total carbon emissions in the system
    }
}

public class GondolaMath {
    public static void main(String[] args) {

        final int NUMBER_OF_PEOPLE = 10; // also number of cars

        GondolaSystem gondolaSystem = new GondolaSystem(); //The main method creates an instance of the GondolaSystem

        // Adding cars to the system for specific number of people
        for (int i = 1; i <= NUMBER_OF_PEOPLE; i++) {
            gondolaSystem.addCar("Person" + i);
        }

        // Displaying total carbon emission before using the gondola
        System.out.println("Total Carbon Emission (Before): " + gondolaSystem.getTotalCarbonEmission());

        // Using the gondola for each person
        for (int i = 1; i <= NUMBER_OF_PEOPLE; i++) {
            gondolaSystem.useGondola("Person" + i);
        }
    }
}
