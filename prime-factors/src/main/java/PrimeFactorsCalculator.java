import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class PrimeFactorsCalculator {

    public List<Long> calculatePrimeFactorsOf(long number) {
        if (number <= 2) {
            return specialCase(number);
        }

        var listPrimeFactors = new LinkedList<Long>();
        var startPrimeFactor = 2L;

        while (number > 1) {
            if (this.isPrime(startPrimeFactor)) {
                if (startPrimeFactor / number == 0 || startPrimeFactor / number == 1) {
                    listPrimeFactors.add(startPrimeFactor);
                    number /= startPrimeFactor;
                    continue;
                }
            }

            startPrimeFactor++;

        }

        return listPrimeFactors;
    }

    private boolean isPrime(long number) {
        if (number == 1) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (long i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private List<Long> specialCase(long number) {
        return number == 2 ? singletonList(number) : emptyList();
    }

}