import java.util.ArrayList;
import java.util.List;

public class Series {
    private final String seriesNumber;
    private final List<String> listString = new ArrayList<>();

    public Series(String seriesNumber) { this.seriesNumber = seriesNumber; }

    public List<String> slices(int sliceLen) {
        if(sliceLen > seriesNumber.length()) throw new IllegalArgumentException("Slice size is too big.");
        if(sliceLen <= 0) throw new IllegalArgumentException("Slice size is too small.");
        if(sliceLen == 1 && seriesNumber.length() == 1) return List.of(seriesNumber);

        for (int i = 0; i < seriesNumber.length(); i++) {

            if(i+sliceLen > seriesNumber.length()) break;
            listString.add(seriesNumber.substring(i, i+sliceLen));

        }

       return listString;
    }
}