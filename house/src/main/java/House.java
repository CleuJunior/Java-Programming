public class House {

    private final String SONG_VERSE_TWELVE = "This is the horse and the hound and the horn " +
                                             "that belonged to the farmer sowing his corn " +
                                             "that kept the rooster that crowed in the morn " +
                                             "that woke the priest all shaven and shorn " +
                                             "that married the man all tattered and torn " +
                                             "that kissed the maiden all forlorn " +
                                             "that milked the cow with the crumpled horn " +
                                             "that tossed the dog " +
                                             "that worried the cat " +
                                             "that killed the rat " +
                                             "that ate the malt " +
                                             "that lay in the house that Jack built.";

    private final String[] VERSES_OF_THE_SONG = {

            "This is the house that Jack built.",

            "This is the malt " + SONG_VERSE_TWELVE.substring(377),

            "This is the rat " + SONG_VERSE_TWELVE.substring(359),

            "This is the cat " + SONG_VERSE_TWELVE.substring(339),

            "This is the dog " + SONG_VERSE_TWELVE.substring(318),

            "This is the cow with the crumpled horn " + SONG_VERSE_TWELVE.substring(298),

            "This is the maiden all forlorn " + SONG_VERSE_TWELVE.substring(255),

            "This is the man all tattered and torn " + SONG_VERSE_TWELVE.substring(220),

            "This is the priest all shaven and shorn " + SONG_VERSE_TWELVE.substring(177),

            "This is the rooster that crowed in the morn " + SONG_VERSE_TWELVE.substring(135),

            "This is the farmer sowing his corn " + SONG_VERSE_TWELVE.substring(89),

            SONG_VERSE_TWELVE
    };

    public String verse(int intValueVerse) { return VERSES_OF_THE_SONG[intValueVerse-1]; }

    public String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();

       for(int i = startVerse-1; i < endVerse; i++) {
           sb.append(VERSES_OF_THE_SONG[i]).append('\n');
       }

       return sb.toString().trim();

    }

    public String sing() {
        StringBuilder sb = new StringBuilder();

        for(String singTheWholeSong : VERSES_OF_THE_SONG) {
            sb.append(singTheWholeSong).append('\n');
        }

        return sb.toString().trim();

    }
}