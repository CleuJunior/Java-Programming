import java.util.HashMap;
import java.util.Map;

class BeerSong {

    private static final Map<Integer, String> specialCases = new HashMap<>();
    private final StringBuilder song = new StringBuilder();

    static {
        specialCases.put(0, """
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.
                
                """);

        specialCases.put(1, """
                1 bottle of beer on the wall, 1 bottle of beer.
                Take it down and pass it around, no more bottles of beer on the wall.
                
                """);

        specialCases.put(2, """
                2 bottles of beer on the wall, 2 bottles of beer.
                Take one down and pass it around, 1 bottle of beer on the wall.
                
                """);
    }

    private String singVerseNumSong(int verseNum) {
        return """
                %d bottles of beer on the wall, %d bottles of beer.
                Take one down and pass it around, %d bottles of beer on the wall.
                
                """.formatted(verseNum, verseNum, verseNum - 1);
    }

    public String sing(int totalOfBottle, int subtractBottle) {
        int subtract = totalOfBottle;

        for (int i = 0; i < subtractBottle; i++) {

            if (extractSong(subtract)) {
                subtract -= 1;
                continue;
            }

            song.append(singVerseNumSong(subtract));
            subtract -= 1;
        }

        return song.toString();
    }

    private boolean extractSong(int i) {
        boolean checkConditionsSong = (i == 2 || i == 1 || i == 0);

        if (checkConditionsSong)
            song.append(specialCases.get(i));

        return checkConditionsSong;
    }

    public String singSong() {
        for (int i = 99; i >= 0; i--) {

            if (extractSong(i))
                continue;

            song.append(singVerseNumSong(i));
        }

        return song.toString();
    }
}