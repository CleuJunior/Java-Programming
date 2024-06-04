class BottleSong {

    private static final String[] NUMBERS = new String[]
            {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final String BASE_LINE_ONE = " green bottles hanging on the wall,\n";
    private static final String BASE_LINE_TWO = "And if one green bottle should accidentally fall,\n";
    private static final String BASE_LINE_THREE = "There'll be ";
    private static final String BASE_LINE_FOUR = " green bottles hanging on the wall.\n";
    private static final String ESPECIAL_CASE = "There'll be one green bottle hanging on the wall.\n";


    public String recite(int start, int end) {
        start--;
        var sb = new StringBuilder();

        for (int i = 0; i < end; i++) {
            sb
                    .append(NUMBERS[start + i])
                    .append(BASE_LINE_ONE)
                    .append(NUMBERS[start + i])
                    .append(BASE_LINE_ONE)
                    .append(BASE_LINE_TWO);


            if (!"One".equals(NUMBERS[start + i - 1])) {
                sb.append(ESPECIAL_CASE);

            } else {
                sb.append(BASE_LINE_THREE)
                        .append((NUMBERS[start + i - 1].toLowerCase()))
                        .append(BASE_LINE_FOUR);
            }
        }


        return sb.toString();

    }
}