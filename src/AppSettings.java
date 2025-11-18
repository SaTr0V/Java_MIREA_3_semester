import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppSettings {
    // Заккрытая статическая переменная для хранения единственного экземпляра
    private static volatile AppSettings instance;

    // Хранилище настроек
    private final Map<String, String> settings = new ConcurrentHashMap<>();

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private AppSettings() {}

    // Потокобезопасный метод получения единственного экземпляра
    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public void setSetting(String key, String value) {
        if (key != null && value != null) {
            settings.put(key, value);
        }
    }

    public String getSetting(String key) {
        return settings.get(key);
    }
}