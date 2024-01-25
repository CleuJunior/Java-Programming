import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

class NaturalNumber {
    private final int number;
    public NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        this.number = number;
    }

    public Classification getClassification() {
        List<Integer> listInteger = new LinkedList<>();

        IntStream.range(1, number).forEach(i -> {
            if (number % i == 0) {
                listInteger.add(i);
            }
        });

        int count = listInteger.stream().mapToInt(Integer::intValue).sum();
        return this.getClassificationFromInteger(count);
    }

    private Classification getClassificationFromInteger(int number) {
        if (number == this.number) {
            return Classification.PERFECT;
        }

        if (number > this.number) {
            return Classification.ABUNDANT;
        }

        return Classification.DEFICIENT;
    }
}
