import java.util.regex.Pattern;

class LuhnValidator implements LuhnPatterns {

    public boolean isValid(String candidate) {
        candidate = cleanCandidate(candidate);

        if(!isValidString(candidate))
            return false;

        return isValidSum(candidate);
    }
    private boolean isValidSum(String candidate) {
        String[] digits = candidate.split("");
        int sum = 0;
        boolean multiply = false;

        for(int i = digits.length - 1; i >= 0; i--){
            int digit = Integer.parseInt(digits[i]);
            sum += multiply ? doubleNumber(digit) : digit;
            multiply = !multiply;
        }

        return sum % 10 == 0;
    }
}