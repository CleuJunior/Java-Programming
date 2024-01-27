import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class School {
    private final Map<String, Integer> roster = new TreeMap<>();

    public boolean add(String student, int grade) {
        int auxLen = this.roster.size();

        roster.putIfAbsent(student, grade);

        return roster.size() > auxLen;
    }

    public List<String> roster() {
        return roster.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> grade(int grade) {
        return roster.entrySet().stream()
              .filter(entry -> entry.getValue() == grade)
              .map(Map.Entry::getKey)
              .toList();
    }

}
