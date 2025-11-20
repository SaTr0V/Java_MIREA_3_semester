public class ErrorLogger extends Logger {
    public ErrorLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("[ERROR] " + message);
    }
}