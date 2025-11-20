public class CriticalLogger extends Logger {
    public CriticalLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("[CRITICAL] " + message);
    }
}