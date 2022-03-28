import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Gigasecond {
    private final LocalDateTime localDateTime;
    private static final Long gigaSecond = 1_000_000_000L;

    public Gigasecond(LocalDate moment) { this(moment.atStartOfDay());  }
    public Gigasecond(LocalDateTime moment) { this.localDateTime = moment; }
    public LocalDateTime getDateTime() { return localDateTime.plus(gigaSecond, ChronoUnit.SECONDS);  }
}
