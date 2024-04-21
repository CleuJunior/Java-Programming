import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    private GottaSnatchEmAll() {
    }

    public static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    public static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    public static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return !myCollection.isEmpty() &&
                !theirCollection.isEmpty() &&
                !myCollection.containsAll(theirCollection);
    }

    public static Set<String> commonCards(List<Set<String>> collections) {
        return collections.stream()
                .reduce(GottaSnatchEmAll::compare)
                .orElse(Collections.emptySet());
    }

    private static Set<String> compare(Set<String> s1, Set<String> s2) {
        return s1.stream()
                .filter(s2::contains)
                .collect(Collectors.toSet());
    }

    public static Set<String> allCards(List<Set<String>> collections) {
        return collections.stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }
}
