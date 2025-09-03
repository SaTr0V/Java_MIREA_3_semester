package pr_1;


public class Car {
    String model = "Mazda";
    String license = "М999ММ";
    String color = "Dark-Blue";
    int year = 2024;

    Car() {
        System.out.println("Конструктор по умолчанию");
        System.out.println("Model: " + this.model);
        System.out.println("License: " + this.license);
        System.out.println("Color: " + this.color);
        System.out.println("year: " + this.year);

        System.out.println("------------------------------------------------");
    }

    Car(String model, String license, String color, int year) {
        this.model = model;
        this.license = license;
        this.color = color;
        this.year = year;

        System.out.println("Конструктор со всеми полями:");
        System.out.println("Model: " + this.model);
        System.out.println("License: " + this.license);
        System.out.println("Color: " + this.color);
        System.out.println("year: " + this.year);

        System.out.println("------------------------------------------------");
    }

    Car(String color) {
        this.color = color;

        System.out.println("Конструктор с одним полем (выбор студента):");
        System.out.println("Model: " + this.model);
        System.out.println("License: " + this.license);
        System.out.println("Color: " + this.color);
        System.out.println("year: " + this.year);

        System.out.println("------------------------------------------------");
    }
}
