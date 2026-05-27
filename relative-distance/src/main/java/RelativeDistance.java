import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class RelativeDistance {

    private final Map<String, List<String>> familyTree = new HashMap<>();

    public RelativeDistance(Map<String, List<String>>  familyTree) {
        this.familyTree.putAll(familyTree);
    }

    public int degreeOfSeparation(String personA, String personB) {
        if (personA.equals(personB))
            return 0;

        var graph = this.undirectedGraph(familyTree);

        if (!graph.containsKey(personA) || !graph.containsKey(personB))
            return -1;

        return bfs(personA, personB, graph);
    }

    private Map<String, Set<String>> undirectedGraph(Map<String, List<String>> tree) {
        var graph = new HashMap<String, Set<String>>();

        for (var entry : tree.entrySet()) {
            var parent = entry.getKey();
            var children = entry.getValue();

            graph.putIfAbsent(parent, new HashSet<>());

            for (String child: children) {
                graph.putIfAbsent(child, new HashSet<>());
                graph.get(parent).add(child);
                graph.get(child).add(parent);
            }

            for (int i = 0; i < children.size(); i++) {
                for (int j = i + 1; j < children.size(); j++) {
                    String childA = children.get(i);
                    String childB = children.get(j);
                    graph.get(childA).add(childB);
                    graph.get(childB).add(childA);
                }
            }
        }

        return graph;
    }

    private int bfs(String personA, String personB, Map<String, Set<String>> graph) {
        var queue = new ArrayDeque<PersonDistance>();
        var visited = new HashSet<String>();

        queue.add(new PersonDistance(personA, 0));
        visited.add(personA);

        while(!queue.isEmpty()) {
            var current = queue.remove();

            if (current.name.equals(personB))
                return current.distance;

            for (String neighbor : graph.get(current.name)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new PersonDistance(neighbor, current.distance + 1));
                }
            }
        }

        return -1;
    }

    private record PersonDistance(String name, int distance){
    }
}
