public class WarningLogger extends Logger {
    public WarningLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("[WARNING] " + message);
    }
}