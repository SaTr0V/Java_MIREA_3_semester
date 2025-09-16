package app;

import vehicles.Vehicle;
import vehicles.Car;
import vehicles.ElectricCar;

public class TestCar {
    public static void main(String[] args) {
        System.out.println("ТЕСТИРОВАНИЕ СИСТЕМЫ ТРАНСПОРТНЫХ СРЕДСТВ\n");

        System.out.println("1. СОЗДАНИЕ ОБЫЧНОГО АВТОМОБИЛЯ (через Vehicle):");
        Car car = new Car("Audi", "A999AA", "Green", 2009);
        car.to_String();

        System.out.println("\n2. СОЗДАНИЕ ЭЛЕКТРОМОБИЛЯ (через Vehicle):");
        ElectricCar e_car = new ElectricCar("Tesla Model S", "E001EE", "White", 2025, 100.0);
        e_car.to_String();

        System.out.println("\n3. ИЗМЕНЕНИЕ СВОЙСТВ ЧЕРЕЗ СЕТТЕРЫ:");

        // Изменяем свойства через методы родительского класса
        System.out.println("Set new properties for an ordinary car:");
        car.setYear();
        car.setOwnerName();
        car.setInsuranceNumber();

        System.out.println("\nSet new properties for an electric car:");
        e_car.setYear();
        e_car.setOwnerName();
        e_car.setInsuranceNumber();

        System.out.println("\nElectric car's battery capacity: " + e_car.getBatteryCapacity() + " kWh");

        System.out.println("\n4. ВЫВОД ИНФОРМАЦИИ О ТРАНСПОРТНЫХ СРЕДСТВАХ:");
        System.out.println("\nUpdated info:");
        System.out.println("------------------------------------------------");
        car.to_String();
        e_car.to_String();
    }
}