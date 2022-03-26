/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/


import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.sort;

class Anagram {
    private String anagramString;
    Anagram(String anagramString) { this.anagramString = anagramString; }

    /*
     * Makes all the Array of String Lowercase
    */
    private String[] standardizedStings(String[] string) {
        String[] toReturn = new String[string.length];
        for (int i = 0; i < string.length; i++) { toReturn[i] = string[i].toLowerCase(); }
        return toReturn;
    }

    /*
     * Join an Array of String into a String in alphabetical order
     */
    private String joinStringAndSort(String[] stringToJoin) {
        String[] toReturn = standardizedStings(stringToJoin);
        sort(toReturn);
        String joinedString = "";
        for (String stringForeEach: toReturn) { joinedString += stringForeEach; }
        return joinedString;
    }

    /*
     * Check if the Anagram is the same String in the List
     */
    private boolean checkIfIsEquals(List<String> checkStringEquals, String anagram) {
        for (String stringForeEach: checkStringEquals) { if(stringForeEach.equals(anagram)) return true; }
        return false;
    }

    /*
     * Check if there is more than 1 Anagram in the List
     */
    private List<String> checkAnagramOfAnagramString(List<String> anagramCandidates) {
        List<String> anotherAnagramList = new ArrayList<>();

        for (String stringForeEach: anagramCandidates) {
            if(!stringForeEach.equalsIgnoreCase(anagramString)) anotherAnagramList.add(stringForeEach);
        }

        return checkIfIsEquals(anagramCandidates, anagramString) ? anotherAnagramList : null;
    }

    private String stringOrder() {
        String newStringAnagram = joinStringAndSort(anagramString.split("")).toLowerCase();
        newStringAnagram = joinStringAndSort(newStringAnagram.split(""));
        return newStringAnagram;
    }

    public List<String> match(List<String> anagramCandidates) {
        List<String> anotherAnagramList = checkAnagramOfAnagramString(anagramCandidates);
        if (anotherAnagramList != null) return anotherAnagramList;

        List<String> anagramFound = new ArrayList<>();
        String newStringAnagram = stringOrder();
        String testAnagram = "";

        for (String anagramCandidatesForEach: anagramCandidates) {
            testAnagram = joinStringAndSort(anagramCandidatesForEach.split(""));
            if(newStringAnagram.equals(testAnagram)) anagramFound.add(anagramCandidatesForEach);

        }

        return anagramFound;
    }

}