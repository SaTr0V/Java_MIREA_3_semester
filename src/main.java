public class main {
    public static void main(String[] args) throws InterruptedException {
        // Запускаем несколько потоков, которые будут работать с AppSettings
        Thread t1 = new Thread(() -> {
            AppSettings settings = AppSettings.getInstance();
            settings.setSetting("theme", "dark");
            System.out.println("Поток 1 - Тема: " + settings.getSetting("theme"));
        });

        Thread t2 = new Thread(() -> {
            AppSettings settings = AppSettings.getInstance();
            settings.setSetting("language", "ru");
            System.out.println("Поток 2 - Язык: " + settings.getSetting("language"));
        });

        Thread t3 = new Thread(() -> {
            AppSettings settings = AppSettings.getInstance();
            // Проверим, что настройки из других потоков доступны
            System.out.println("Поток 3 - Тема: " + settings.getSetting("theme"));
            System.out.println("Поток 3 - Язык: " + settings.getSetting("language"));
        });

        t1.start();
        t2.start();
        t3.start();

        // Ожидаем завершения всех потоков
        t1.join();
        t2.join();
        t3.join();

        // Проверка из основного потока
        AppSettings mainSettings = AppSettings.getInstance();
        System.out.println("Основной поток - Тема: " + mainSettings.getSetting("theme"));
        System.out.println("Основной поток - Язык: " + mainSettings.getSetting("language"));

        // Проверка, что все потоки работали с одним и тем же экземпляром
        AppSettings inst1 = AppSettings.getInstance();
        AppSettings inst2 = AppSettings.getInstance();
        AppSettings inst3 = AppSettings.getInstance();
        System.out.println("Все потоки используют один и тот же экземпляр: " + (inst1 == inst2 && inst2 == inst3));
    }
}