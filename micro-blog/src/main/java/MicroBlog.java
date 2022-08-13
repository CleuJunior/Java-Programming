class MicroBlog {
    public String truncate(final String input) {
        return input.length() < 6 ? input : truncateUnicode(input);
    }

    private String truncateUnicode(final String input) {
        return input.substring(0, input.offsetByCodePoints(0, 5));
    }
}