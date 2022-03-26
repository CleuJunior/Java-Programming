import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private String word;
    private Map<Character, Integer> mapValueString = new HashMap<>();

    Scrabble(String word) { this.word = word.toLowerCase(); }


    private void setValuesMap(String stdString, int value) {
        for (int i = 0; i < stdString.length(); i++) { mapValueString.put(stdString.charAt(i), value); }
    }

    private void setMapValueString() {
        setValuesMap("aeioulnrst", 1);
        setValuesMap("dg", 2);
        setValuesMap("bcmp", 3);
        setValuesMap("fhvwy", 4);
        setValuesMap("jx", 8);
        setValuesMap("qz", 10);
        mapValueString.put('k', 5);

    }


    int getScore() {
        setMapValueString();
        int count = 0;

        for (int i = 0; i < word.length(); i++) { count += mapValueString.get(word.charAt(i));  }
        return count;
    }

}
