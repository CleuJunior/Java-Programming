import java.math.BigInteger;

class PrimeCalculator {

    public int nth(int nth) {
        if (nth < 1)  {
            throw new IllegalArgumentException();
        }


        for (int i = 2; true; i++) {
            BigInteger bigInteger = BigInteger.valueOf(i);

            if (bigInteger.isProbablePrime())

        }

        return 100;
    }
}
