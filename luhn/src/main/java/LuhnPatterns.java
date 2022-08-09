import java.util.regex.Pattern;

public interface LuhnPatterns {
    default String cleanCandidate(String candidate) {
        return candidate.replaceAll(" ", "");
    }

    default int doubleNumber(int number) {
        number = number * 2;
        return number > 9 ? number - 9 : number;
    }

    default boolean isValidString(String candidate) {
        return candidate.length() > 1 &&
                Pattern.compile("^\\d+$")
                        .matcher(candidate)
                        .matches();
    }
}
