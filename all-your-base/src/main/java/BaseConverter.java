import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BaseConverter {

    private final int sourceBase;
    private final int[] digits;

    public BaseConverter(int sourceBase, int[] digits) {
        if (sourceBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        for (int digit : digits) {
            if (digit < 0 || digit >= sourceBase) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
        }

        this.sourceBase = sourceBase;
        this.digits = digits.clone();
    }

    public List<Integer> convertToBase(int targetBase) {
        if (targetBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        int decimalValue = convertToDecimal();
        return convertFromDecimal(decimalValue, targetBase);
    }

    private int convertToDecimal() {
        int decimalValue = 0;
        int power = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            decimalValue += digits[i] * Math.pow(sourceBase, power);
            power++;
        }

        return decimalValue;
    }

    private List<Integer> convertFromDecimal(int decimalValue, int targetBase) {
        if (decimalValue == 0) {
            return Collections.singletonList(0);
        }

        List<Integer> result = new ArrayList<>();

        while (decimalValue > 0) {
            int remainder = decimalValue % targetBase;
            result.add(remainder);
            decimalValue /= targetBase;
        }

        Collections.reverse(result);
        return result;
    }
}