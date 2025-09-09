package vehicles;

public class Car extends Vehicle {
    public Car(String model, String license, String color, int year) {
        super(model, license, color, year);
    }

    // Специализированный тип
    @Override
    public String vehicleType() {
        return "Car";
    }
}
