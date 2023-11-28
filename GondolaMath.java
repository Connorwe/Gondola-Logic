import java.util.HashMap;
import java.util.Map;

class Car {
    private static final double CARBON_EMISSION_PER_PERSON = 1480;

    public double getCarbonEmission() {
        return CARBON_EMISSION_PER_PERSON;
    }
}

class GondolaSystem {
    private Map<String, Car> cars;
    private double totalCarbonEmission;

    public GondolaSystem() {
        this.cars = new HashMap<>();
        this.totalCarbonEmission = 0.0;
    }

    public void addCar(String owner) {
        Car car = new Car();
        cars.put(owner, car);
        totalCarbonEmission += car.getCarbonEmission();
    }

    public void useGondola(String owner) {
        if (cars.containsKey(owner)) {
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
        return totalCarbonEmission;
    }
}

public class GondolaMath {
    public static void main(String[] args) {

        final int NUMBER_OF_PEOPLE = 10; // also number of cars

        GondolaSystem gondolaSystem = new GondolaSystem();

        // Adding cars to the system
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
