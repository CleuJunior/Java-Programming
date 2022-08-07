import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Meetup {
    private LocalDate dateSchedule;

    public Meetup(Integer month, Integer year) {
        this.dateSchedule = LocalDate.of(year, month, 1);
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetup) {
        if(meetup.equals(MeetupSchedule.LAST))
            return dateSchedule.with(TemporalAdjusters.lastInMonth(dayOfWeek));

        if(meetup.equals(MeetupSchedule.FIRST))
            return dateSchedule.with(TemporalAdjusters.firstInMonth(dayOfWeek));

        if(isPattern(meetup))
            return adjustTimeDate(meetup, dayOfWeek);

       while(!(dateSchedule.getDayOfMonth() >= 13 && dateSchedule.getDayOfMonth() <= 19)) {
           dateSchedule = dateSchedule.with(TemporalAdjusters.next(dayOfWeek));
       }

        return dateSchedule;
    }

    private LocalDate adjustTimeDate(MeetupSchedule meetup, DayOfWeek dayOfWeek) {
        return this.dateSchedule.with(TemporalAdjusters.dayOfWeekInMonth(meetup.ordinal() +1, dayOfWeek));
    }

    private boolean isPattern(MeetupSchedule meetup) {
        return meetup.equals(MeetupSchedule.SECOND) || meetup.equals(MeetupSchedule.THIRD) ||
                meetup.equals(MeetupSchedule.FOURTH);
    }
}