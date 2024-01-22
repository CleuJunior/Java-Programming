import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

class AppointmentScheduler {
    private static final int TWELVE_HOURS = 12;
    private static final int EIGHTEEN_HOURS = 18;
    public static final String YOU_HAVE_AN_APPOINTMENT_ON = "You have an appointment on ";
    public static final String AT = ", at ";
    private static final String COMMA =  ", ";
    private static final String BLANK_SPACE =  " ";
    private static final String PERIOD =  ".";
    public static final TextStyle TEXT_STYLE_FULL = TextStyle.FULL;
    public static final Locale LOCALE_ENGLISH = Locale.ENGLISH;

    public LocalDateTime schedule(String appointmentDateDescription) {
        int year = this.getIntFromString(appointmentDateDescription,6, 10);
        int month = this.getIntFromString(appointmentDateDescription, 0, 2);
        int dayOfMonth = this.getIntFromString(appointmentDateDescription, 3, 5);
        int hour = this.getIntFromString(appointmentDateDescription, 11, 13);
        int minute = this.getIntFromString(appointmentDateDescription,14, 16);
        int second = this.getIntFromStringFinalLength(appointmentDateDescription);

        return LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
    }

    private int getIntFromString(String appointmentDateDescription, int beginIndex, int endIndex) {
        return Integer.parseInt(appointmentDateDescription.substring(beginIndex, endIndex));
    }

    private int getIntFromStringFinalLength(String appointmentDateDescription) {
        return Integer.parseInt(appointmentDateDescription.substring(17));
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return !appointmentDate.isAfter(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        return appointmentDate.getHour() >= TWELVE_HOURS && appointmentDate.getHour() < EIGHTEEN_HOURS;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        String dayOfWeek = appointmentDate.getDayOfWeek().getDisplayName(TEXT_STYLE_FULL, LOCALE_ENGLISH);
        String month = appointmentDate.getMonth().getDisplayName(TEXT_STYLE_FULL, LOCALE_ENGLISH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a", LOCALE_ENGLISH);
        String formattedHours = appointmentDate.format(formatter);

        return YOU_HAVE_AN_APPOINTMENT_ON +
                dayOfWeek +
                COMMA +
                month +
                BLANK_SPACE +
                appointmentDate.getDayOfMonth() +
                COMMA +
                appointmentDate.getYear() +
                AT +
                formattedHours +
                PERIOD;
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), Month.SEPTEMBER, 15);
    }

}
