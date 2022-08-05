import java.util.List;
import java.util.ArrayList;
public class PigLatinTranslator {

    String translate(String source) {
        String[] words = source.split(" ");
        List<String> plWords = new ArrayList<>();

        for (String word : words) {
            char c0 = word.charAt(0);
            char c1 = word.charAt(1);
            StringBuilder pl = new StringBuilder(word);

            if (isVowel(c0) || (c0 == 'x' && c1 == 'r') || (c0 == 'y' && c1 == 't')) {
                pl.append("ay");
            } else if (!isVowel(c0)) {
                StringBuilder cluster = new StringBuilder();

                if (word.length() >= 3 && c1 == 'q' && word.charAt(2) == 'u') {
                    cluster.append(word, 0, 3);
                } else if (c0 == 'q' && c1 == 'u') {
                    cluster.append(word, 0, 2);
                } else {
                    cluster.append(c0);
                    for (int i = 1; i < word.length(); i++) {
                        char let = word.charAt(i);
                        if (!isVowel(let) && let != 'y') {
                            cluster.append(let);
                        } else {
                            break;
                        }
                    }
                }
                pl.delete(0, cluster.length());
                pl.append(cluster);
                pl.append("ay");
            }
            plWords.add(pl.toString());
        }

        StringBuilder result = new StringBuilder();
        for (String word : plWords) {
            result.append(word);
            result.append(' ');
        }
        return result.toString().strip();
    }
    boolean isVowel(char letter) {
        return switch (Character.toLowerCase(letter)) {
            case 'a', 'e', 'u', 'i', 'o' -> true;
            default -> false;
        };
    }
}