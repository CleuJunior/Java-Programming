import java.awt.*;

public enum LogLevel {

    TRACE( 1, "TRC" ),
    DEBUG( 2, "DBG" ),
    INFO( 4,"INF" ),
    WARNING( 5, "WRN" ),
    ERROR( 6, "ERR" ),
    FATAL( 42, "FTL" ),
    UNKNOWN(0,  "UNKNOWN" );

    private final int id;
    private final String logName;

    LogLevel(int id, String logName) {
        this.id = id;
        this.logName = logName;
    }

    public int getId() {
        return id;
    }

    public String getLogName() {
        return logName;
    }

    public static LogLevel of(String level) {
        for (LogLevel lvl : LogLevel.values()) {
            if (level.contains(lvl.getLogName())) {
                return lvl;
            }
        }
        return UNKNOWN;
    }
}
