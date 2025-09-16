package vehicles;

public class Car extends Vehicle {
    public Car(String model, String license, String color, int year) {
        super(model, license, color, year);
        this.engineType = "Combustion";
    }

    // Специализированный тип
    @Override
    public String vehicleType() {
        return "Car";
    }
}
