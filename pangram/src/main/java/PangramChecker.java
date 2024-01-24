public class PangramChecker {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public boolean isPangram(String input) {
        return ALPHABET
                .chars()
                .allMatch(c -> input.toLowerCase().indexOf(c) >= 0);
    }

}
