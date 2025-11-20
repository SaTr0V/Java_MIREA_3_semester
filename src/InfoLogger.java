public class InfoLogger extends Logger {
    public InfoLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("[INFO] " + message);
    }
}