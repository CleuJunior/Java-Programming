import java.util.stream.IntStream;

public class SquareRoot {
    public int squareRoot(int radicand) {
        if (radicand == 0 || radicand == 1) {
            return radicand;
        }

        double guess = radicand / 2.0;

        while (Math.abs(guess * guess - radicand) > 0.1) {
            guess = 0.5 * (guess + radicand / guess);
        }

        return (int) guess;
    }
}
