public class DebugLogger extends Logger {
    public DebugLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("[DEBUG] " + message);
    }
}