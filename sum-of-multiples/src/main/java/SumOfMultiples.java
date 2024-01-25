import java.util.Arrays;
import java.util.HashSet;

class SumOfMultiples {
    private final int level;
    private final int[] set;

    SumOfMultiples(int level, int[] set) {
        this.level = level;
        this.set = set;
    }

    int getSum() {
        var setInteger = new HashSet<Integer>();

        Arrays.stream(set).filter(i -> i > 0).forEach(i -> {
            for (int j = i; j < level; j+=i) {
                setInteger.add(j);
            }

        });

        return setInteger.stream()
                .mapToInt(Integer::intValue)
                .sum();

    }

}
