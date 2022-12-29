class LargestSeriesProductCalculator {
    private final String inputNumber;

    public LargestSeriesProductCalculator(String inputNumber) {
        if(inputNumber.matches(".*[a-zA-Z]+.*"))
            throw new IllegalArgumentException("String to search may only contain digits.");

        this.inputNumber = inputNumber;
    }

    public long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(numberOfDigits > inputNumber.length())
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");

        if(numberOfDigits < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");

        if(inputNumber.equals(""))
            return 1L;

        if(numberOfDigits == 0)
            return 1L;

        long maxProduct = 0L;
        for (int i = 0; i < inputNumber.length() - numberOfDigits + 1; i++) {
            long product = 1;
            for (int j = i; j < i + numberOfDigits; j++) {
                product *= Integer.parseInt(String.valueOf(inputNumber.charAt(j)));
            }

            maxProduct = Math.max(maxProduct, product);
        }

        return maxProduct;
    }
}
