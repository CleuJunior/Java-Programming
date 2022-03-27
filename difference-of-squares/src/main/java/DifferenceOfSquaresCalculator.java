class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        if(input == 0) return 1;

        int sumSquareOfSum = 0;

        for (int i = 1; i <= input; i++) { sumSquareOfSum += i; }
        return (int) Math.pow(sumSquareOfSum, 2);
    }

    int computeSumOfSquaresTo(int input) {
        int sumSquareOfSum = 0;

        for (int i = 1; i <= input; i++) { sumSquareOfSum += (int) Math.pow(i, 2); }
        return sumSquareOfSum;
    }

    int computeDifferenceOfSquares(int input) { return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input); }

}
