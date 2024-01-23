class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String numStr = String.valueOf(numberToCheck);
        int numDigits = numStr.length();
        int armstrongSum = 0;

        for (char digitChar : numStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            armstrongSum += (int) Math.pow(digit, numDigits);
        }

        return armstrongSum == numberToCheck;
    }

}
