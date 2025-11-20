public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.png");

        // Изображение еще не загружено на данном этапе
        System.out.println("Созданы прокси-изображения.");
        System.out.println("Первый вызов display() для photo1.jpg:");
        image1.display(); // загрузка и отображение

        System.out.println("\nВторой вызов display() для photo1.jpg:");
        image1.display(); // только отображение, так как image1 уже загружено

        System.out.println("\nВызов display() для photo2.png:");
        image2.display(); // новое изображение — загружается и отображается
    }
}