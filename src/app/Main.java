package app;

import vehicles.Car;
import vehicles.ElectricCar;

public class Main {
    public static void main(String[] args) {
        System.out.println("ДЕМОНСТРАЦИЯ НАСЛЕДОВАНИЯ И ИНКАПСУЛЯЦИИ\n");

        // Обычный автомобиль
        System.out.println("1. СОЗДАНИЕ ОБЫЧНОГО АВТОМОБИЛЯ:");

        Car regularCar = new Car("Audi", "A999AA", "Green", 2009);
        regularCar.To_String();

        System.out.println("\n2. ДОСТУП К ПОЛЯМ ОБЫЧНОГО АВТОМОБИЛЯ:");

        System.out.println("Public property model: " + regularCar.model);
        System.out.println("Public property color: " + regularCar.color);

        // regularCar.ownerName - недоступно напрямую, но можно использовать геттер
        regularCar.setName();

        // Аналогично с regularCar.engineType
        regularCar.setEngineType();

        // Отображение всей информации о машине
        System.out.println("\nCar info:");
        System.out.println("------------------------------------------------");
        regularCar.To_String();

        System.out.println("\n3. СОЗДАНИЕ ЭЛЕКТРОМОБИЛЯ:");

        ElectricCar electricCar = new ElectricCar("Tesla Model S", "E001EE", "White", 2025, 100.0);
        electricCar.To_String();

        System.out.println("\n4. ДЕМОНСТРАЦИЯ НАСЛЕДОВАНИЯ:");

        // Все открытые методы и поля Car доступны в ElectricCar
        System.out.println("Inherited property model: " + electricCar.model);
        System.out.println("Inherited property color: " + electricCar.color);

        // Защищенное поле доступно в подклассе
        System.out.println("Protected поле engineType: " + electricCar.getEngineType());

        // Вызов унаследованного метода
        electricCar.setName();

        // Отображение всей информации о машине
        System.out.println("\nCar info:");
        System.out.println("------------------------------------------------");
        electricCar.To_String();;

        // Вызов специфичного метода электромобиля
        electricCar.chargeBattery();

        System.out.println("------------------------------------------------" + "\n");

        System.out.println("5. ПРОВЕРКА ИНКАПСУЛЯЦИИ:");

        // Попытка доступа к приватным полям (вызовет ошибку компиляции)
        // System.out.println(tesla.batteryCapacity); // Ошибка - private поле
        // System.out.println(tesla.ownerName); // Ошибка - private поле

        // Правильный доступ через геттеры
        System.out.println("Battery capacity: " + electricCar.getBatteryCapacity() + " kWh");

        // Изменение через сеттер
        electricCar.setBatteryCapacity();
        System.out.println("New battery capacity: " + electricCar.getBatteryCapacity() + " kWh");
    }
}