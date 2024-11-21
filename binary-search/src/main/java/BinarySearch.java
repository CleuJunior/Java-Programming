import java.util.List;

class BinarySearch {
    private final List<Integer> listOfNumbers;

    public BinarySearch(List<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    public int indexOf(int search) throws ValueNotFoundException {
        int start = 0;
        int last = listOfNumbers.size() - 1;

        while (start <= last) {

            int middle = (start + last) / 2;
            int compare = Integer.compare(listOfNumbers.get(middle), search);

            switch (compare) {
                case -1 -> start = middle + 1;
                case 1 -> last = middle - 1;
                default -> {
                    return middle;
                }
            }
        }

        throw new ValueNotFoundException("Value not in array");
    }

}
