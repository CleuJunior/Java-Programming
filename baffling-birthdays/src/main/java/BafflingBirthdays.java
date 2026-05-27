import java.time.LocalDate;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class BafflingBirthdays {

    private static final int SAMPLE_MAX_VALUE = 100_000;
    private static final int PERCENTAGE = 100;
    private static final int YEAR = 2023;

    public boolean sharedBirthday(List<LocalDate> birthdays) {
        var set = new HashSet<MonthDay>();

        for (LocalDate bd: birthdays) {
            if (set.contains(MonthDay.of(bd.getMonth(), bd.getDayOfMonth()))) {
                return true;
            }

            set.add(MonthDay.of(bd.getMonth(), bd.getDayOfMonth()));
        }

        return false;
    }

    public List<LocalDate> randomBirthdates(int groupSize) {
        var list = new ArrayList<LocalDate>();

        for (int i = 0; i < groupSize; i++) {
            var days = ThreadLocalRandom.current().nextInt(1, 366);
            var date = LocalDate.ofYearDay(YEAR, days);
            list.add(date);
        }

        return list;
    }

    public double estimatedProbabilityOfSharedBirthday(int groupSize) {
        var count = 0;

        for (int i = 0; i < SAMPLE_MAX_VALUE; i++) {
            var list = randomBirthdates(groupSize);
            if (sharedBirthday(list)) {
                count++;
            }
        }

        return (double) count / SAMPLE_MAX_VALUE * PERCENTAGE;
    }
}