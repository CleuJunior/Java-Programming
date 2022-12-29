class IsbnVerifier {

    public boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.replaceAll("-", "");

        if (stringToVerify.length() != 10)
            return false;

        final String NO_PATTERN = "ABCDEFGHIJKLMNOPQRSTUVWYZ";

        for(char c : NO_PATTERN.toCharArray()) {
            if (stringToVerify.contains(Character.toString(c)))
                return false;
        }

        int count = 0;
        for(int i = 0; i < stringToVerify.length(); i++) {
            if (stringToVerify.charAt(i) == 'X') {
                count += (10-i) * 10;
                break;
            }
            count += Character.getNumericValue(stringToVerify.charAt(i)) * (10-i);
        }

        return count % 11 == 0;
    }
}
