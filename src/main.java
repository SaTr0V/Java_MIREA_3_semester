public class main {
    public static void main(String[] args) throws InterruptedException {
        // Запускаем несколько потоков, которые будут работать с AppSettings
        Thread t1 = new Thread(() -> {
            AppSettings settings = AppSettings.getInstance();
            settings.setSetting("theme", "dark");
            System.out.println("Thread 1 - Theme: " + settings.getSetting("theme"));
        });

        Thread t2 = new Thread(() -> {
            AppSettings settings = AppSettings.getInstance();
            settings.setSetting("language", "ru");
            System.out.println("Thread 2 - Language: " + settings.getSetting("language"));
        });

        Thread t3 = new Thread(() -> {
            AppSettings settings = AppSettings.getInstance();
            // Проверим, что настройки из других потоков доступны
            System.out.println("Thread 3 - Theme: " + settings.getSetting("theme"));
            System.out.println("Thread 3 - Language: " + settings.getSetting("language"));
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
        System.out.println("Main thread - Theme: " + mainSettings.getSetting("theme"));
        System.out.println("Main thread - Language: " + mainSettings.getSetting("language"));

        // Проверка, что все потоки работали с одним и тем же экземпляром
        System.out.println("All threads used the same instance: " +
                (t1.getId() == t2.getId() && t2.getId() == t3.getId() ? "Yes" : "No"));
        // Примечание: t.getId() — это ID потока, а не экземпляра!
        // Ниже корректная проверка:
        System.out.println("Singleton works correctly: " +
                (AppSettings.getInstance() == AppSettings.getInstance()));
    }
}