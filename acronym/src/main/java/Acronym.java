class Acronym {

    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        var sb = new StringBuilder();
        var words = this.phrase.replaceAll("[^a-zA-Z ']", " ").split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(word.charAt(0));
            }
        }

        return sb.toString().toUpperCase();
    }

}
