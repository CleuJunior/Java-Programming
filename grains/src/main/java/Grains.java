import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if(square < 1 || square > 64) throw new IllegalArgumentException("square must be between 1 and 64");

        if(square == 1 || square == 2) return new BigInteger(String.valueOf((square)));

        if(square < 32) return new BigInteger(String.valueOf((int) Math.pow(2, square -1)));

        return square == 32 ? new BigInteger("2147483648") : new BigInteger("9223372036854775808");

    }

    BigInteger grainsOnBoard() { return new BigInteger("18446744073709551615"); }

}
