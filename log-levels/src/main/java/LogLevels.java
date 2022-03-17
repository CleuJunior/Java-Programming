import java.util.Arrays;

public class LogLevels {
    
    public static String message(String logLine) { return logLine.split("]:")[1].trim(); }

    public static String logLevel(String logLine) {
        return logLine.contains("ERROR") ? "error" : logLine.contains("WARNING") ? "warning" : "info";
    }

    public static String reformat(String logLine) { return message(logLine).concat(" (" + logLevel(logLine)) +  ")"; }
}
