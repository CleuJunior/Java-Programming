class RotationalCipher {
    private final int SHIFT_KEY;
    private final StringBuilder result = new StringBuilder();

    public RotationalCipher(final int SHIFT_KEY) { this.SHIFT_KEY = SHIFT_KEY; }

    public String rotate(String data) {
        if (SHIFT_KEY == 0 || SHIFT_KEY == 26)
            return data;

        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        for (int i=0; i<data.length(); i++) {

            if (!Character.isLetter(data.charAt(i))) {
                result.append(data.charAt(i));
                continue;
            }

            if (Character.isUpperCase(data.charAt(i))) {
                char letter = Character.toLowerCase(data.charAt(i));
                int index = ALPHABET.indexOf(letter);
                int actualIndex = index + SHIFT_KEY;

                if (actualIndex > 25)
                    actualIndex -= 26;

                result.append(Character.toUpperCase(ALPHABET.charAt(actualIndex)));
                continue;
            }

            int index = ALPHABET.indexOf(data.charAt(i));
            int actualIndex = index + SHIFT_KEY;

            if (actualIndex > 25)
                actualIndex -= 26;

            result.append(ALPHABET.charAt(actualIndex));
        }
        return result.toString();
    }
}