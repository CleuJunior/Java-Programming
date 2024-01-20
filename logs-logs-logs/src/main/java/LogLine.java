public class LogLine {

    private final LogLevel logLevel;
    private final String shortLog;
    private static final String COLON = ":";

    public LogLine(String logLine) {
        this.logLevel = LogLevel.of(logLine);
        this.shortLog = logLine.substring(7);
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    public String getOutputForShortLog() {
        return this.logLevel.getId() + COLON + this.shortLog;
    }
}
