class SqueakyClean {
    private static boolean camel = false;

    static String clean(String identifier) {
        StringBuilder sb = new StringBuilder();

        for (char c : identifier.toCharArray()) {
            switch (Character.getType(c)){
                case Character.DIRECTIONALITY_WHITESPACE -> sb.append("_");
                case Character.CONTROL -> sb.append("CTRL");
                case Character.DASH_PUNCTUATION -> camel = true;
                case Character.UPPERCASE_LETTER,
                        Character.LOWERCASE_LETTER -> {
                    sb.append(treatLetter(c));
                    camel = false;
                }
                default -> {}
            }
        }

        camel = false;
        return sb.toString();
    }
    private static String treatLetter(Character c) {
        if (Character.UnicodeBlock.GREEK.equals(Character.UnicodeBlock.of(c)) && Character.isLowerCase(c))
            return "";

        String result = String.valueOf(c);

        return camel ? result.toUpperCase() : result;
    }
}
