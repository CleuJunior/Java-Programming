import java.util.List;
import java.util.stream.Collectors;

class BinarySearch {
    private final List<Integer> listOfNumbers;

    public BinarySearch(List<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers.stream().sorted().collect(Collectors.toList());
    }

    public int indexOf(int search) throws ValueNotFoundException {
        int start = 0;
        int last = this.listOfNumbers.size() -1;

        while(start <= last) {

            int middle = (start + last) / 2;
            int compare = Integer.compare(this.listOfNumbers.get(middle), search);

            switch(compare) {
                case 0 -> {
                    return middle;
                }
                case -1 -> start = middle + 1;
                case 1 -> last = middle - 1;
            }
        }

        throw new ValueNotFoundException("Value not in array");
    }

}
