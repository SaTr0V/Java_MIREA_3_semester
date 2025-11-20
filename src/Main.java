public class Main {
    public static void main(String[] args) {
        // Создаём цепочку логгеров
        Logger debugLogger = new DebugLogger(LogLevel.DEBUG);
        Logger infoLogger = new InfoLogger(LogLevel.INFO);
        Logger warningLogger = new WarningLogger(LogLevel.WARNING);
        Logger errorLogger = new ErrorLogger(LogLevel.ERROR);
        Logger criticalLogger = new CriticalLogger(LogLevel.CRITICAL);

        // Собираем цепочку
        debugLogger.setNext(infoLogger);        // INFO следующий для DEBUG
        infoLogger.setNext(warningLogger);      // WARNING - для INFO
        warningLogger.setNext(errorLogger);     // ERROR - для WARNING
        errorLogger.setNext(criticalLogger);    // CRITICAL - для ERROR

        // Тестируем разные уровни
        debugLogger.log(LogLevel.DEBUG, "Отладочное сообщение");
        System.out.println("---------------------------------------------------------------------");

        debugLogger.log(LogLevel.INFO, "Информационное сообщение");
        System.out.println("---------------------------------------------------------------------");

        debugLogger.log(LogLevel.WARNING, "Предупреждение");
        System.out.println("---------------------------------------------------------------------");

        debugLogger.log(LogLevel.ERROR, "Ошибка");
        System.out.println("---------------------------------------------------------------------");

        debugLogger.log(LogLevel.CRITICAL, "Критическая ошибка");
    }
}