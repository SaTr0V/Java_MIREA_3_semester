public abstract class Logger {
    protected LogLevel level;
    protected Logger nextLogger;

    public void setNext(Logger next) {
        this.nextLogger = next;
    }

    public void log(LogLevel messageLevel, String message) {
        if (messageLevel.ordinal() == level.ordinal()) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.log(messageLevel, message);
        }
    }

    protected abstract void write(String message);
}