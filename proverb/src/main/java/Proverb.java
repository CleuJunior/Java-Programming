
class Proverb {
    private final String[] WORDS;

    Proverb(String[] words) { this.WORDS = words; }

    public String recite() {
        if(WORDS.length == 0) return "";
        if(WORDS.length == 1) return "And all for the want of a " + WORDS[0] + ".";

        StringBuilder completeSong = new StringBuilder();

        for (int i = 0; i <WORDS.length-1 ; i++) {
            completeSong.append("For want of a ")
                    .append(WORDS[i])
                    .append(" the ")
                    .append(WORDS[i + 1])
                    .append(" was lost.\n");

        }

        completeSong.append("And all for the want of a ").append(WORDS[0]).append(".");

        return completeSong.toString();
    }
}
