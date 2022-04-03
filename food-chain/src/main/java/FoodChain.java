public class FoodChain{

    private final String anOldLady = "I know an old lady who swallowed a ";
    private final String sheSwallowed = "She swallowed the ";
    private final String toCatch= " to catch the ";
    private final String swallowedTheFly = "I don't know why she swallowed the fly. Perhaps she'll die.";
    private final String birdCatchSpider = "She swallowed the bird to catch the spider that wriggled and jiggled and" +
            " tickled inside her.\n";


    private final String[] arraySong = {
            anOldLady + "fly.\n" + swallowedTheFly,

            anOldLady + "spider.\n" +
                    "It wriggled and jiggled and tickled inside her.\n" +
                    sheSwallowed + "spider" + toCatch + "fly.\n" +
                    swallowedTheFly,

            anOldLady + "bird.\n" +
                    "How absurd to swallow a bird!\n" +
                    birdCatchSpider +
                    sheSwallowed + "spider" + toCatch + "fly.\n" +
                    swallowedTheFly,

            anOldLady + "cat.\n" +
                    "Imagine that, to swallow a cat!\n" +
                    sheSwallowed + "cat" + toCatch + "bird.\n" +
                    birdCatchSpider +
                    sheSwallowed + "spider" + toCatch + "fly.\n" +
                    swallowedTheFly,

            anOldLady + "dog.\n" +
                    "What a hog, to swallow a dog!\n" +
                    sheSwallowed + "dog" + toCatch + "cat.\n" +
                    sheSwallowed + "cat" + toCatch + "bird.\n" +
                    birdCatchSpider +
                    sheSwallowed + "spider" + toCatch + "fly.\n" +
                    swallowedTheFly,

            anOldLady + "goat.\n" +
                    "Just opened her throat and swallowed a goat!\n" +
                    sheSwallowed + "goat" + toCatch + "dog.\n" +
                    sheSwallowed + "dog" + toCatch + "cat.\n" +
                    sheSwallowed + "cat" + toCatch + "bird.\n" +
                    birdCatchSpider +
                    sheSwallowed + "spider" + toCatch + "fly.\n" +
                    swallowedTheFly,

            anOldLady + "cow.\n" +
                    "I don't know how she swallowed a cow!\n" +
                    sheSwallowed + "cow" +  toCatch + "goat.\n" +
                    sheSwallowed + "goat" + toCatch + "dog.\n" +
                    sheSwallowed + "dog" + toCatch + "cat.\n" +
                    sheSwallowed + "cat" + toCatch + "bird.\n" +
                    birdCatchSpider +
                    sheSwallowed + "spider" + toCatch + "fly.\n" +
                    swallowedTheFly,

            anOldLady + "horse.\nShe's dead, of course!"

    } ;

    public String verse(int verse) { return arraySong[verse-1]; }

    public String verses(int startVerse, int endVerse) {
        StringBuilder versesStringsBuilder = new StringBuilder();

        for (int i = startVerse; i < endVerse; i++) { versesStringsBuilder.append(verse(i)).append("\n\n"); }

        return versesStringsBuilder.toString().concat(verse(endVerse));
    }
}
