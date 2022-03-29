/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.HashMap;
import java.util.Map;
public class WordCount {
    private final Map<String, Integer> MAP_CHECK_FINAL = new HashMap<>();

    private String[] StdWordsArray(String checkWord) {
        return checkWord
                .toLowerCase()
                .trim()
                .replaceAll("[.\\-_:;?!@^&%$§=]", "")
                .replaceAll("'([a-zA-Z0-9]+)'", "$1")
                .replaceAll("^[,\\s]+", "")
                .split("[,\\s]+");
    }

    public Map<String, Integer> phrase(String checkWord) {
        String[] textToArray = StdWordsArray(checkWord);

        for (String word : textToArray) {
            if (MAP_CHECK_FINAL.containsKey(word)) {
                int auxCount = MAP_CHECK_FINAL.get(word) + 1;
                MAP_CHECK_FINAL.put(word, auxCount);
            }
            if(!MAP_CHECK_FINAL.containsKey(word)) { MAP_CHECK_FINAL.put(word, 1); }
        }
        return MAP_CHECK_FINAL;
    }


}