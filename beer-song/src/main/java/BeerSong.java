/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.HashMap;
import java.util.Map;

class BeerSong {

    private Map<Integer, String> specialCases = new HashMap<>();
    private String song = "";


    public BeerSong() {
        specialCases.put(0 , "No more bottles of beer on the wall, no more bottles of beer." +
                "\nGo to the store and buy some more, 99 bottles of beer on the wall.\n\n");

        specialCases.put(1, "1 bottle of beer on the wall, 1 bottle of beer." +
                "\nTake it down and pass it around, no more bottles of beer on the wall.\n\n");

        specialCases.put(2, "2 bottles of beer on the wall, 2 bottles of beer." +
                "\nTake one down and pass it around, 1 bottle of beer on the wall.\n\n");
    }

    private String SingVerseNumSong(int verseNum) {

        return verseNum + " bottles of beer on the wall, " + verseNum +
                " bottles of beer.\nTake one down and pass it around, " +
                (verseNum-1) + " bottles of beer on the wall.\n\n";
    }

    public String sing(int totalOfBottle, int subtractBottle) {
        int subtract = totalOfBottle;
        for (int i = 0; i < subtractBottle ; i++) {

            if(ExtractSong(subtract)){
                subtract -=1;
                continue;
            }
            this.song += SingVerseNumSong(subtract);
            subtract -=1;
        }

        return song;
    }

    private boolean ExtractSong(int i) {
        boolean checkConditionsSong = (i == 2 || i == 1 || i == 0);

        if(checkConditionsSong) this.song += specialCases.get(i);
        return checkConditionsSong;
    }

    public String singSong() {
        for (int i = 99; i >= 0 ; i--) {
            if (ExtractSong(i)) continue;
            this.song += SingVerseNumSong(i);
        }

        return song;
    }

}