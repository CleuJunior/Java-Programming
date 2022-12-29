public class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
        setPattern();
        checkMatcher();
        checkStartsWith();
        checkCharAt();
        checkLength();
    }

    public String getNumber() {
        return this.number;
    }

    private void setPattern() {
        if(this.number.startsWith("1"))
            this.number = this.number.substring(1);

        if(this.number.startsWith("+1"))
            this.number = this.number.substring(2);

        this.number = this.number
                .replaceAll("\\.", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("-", "")
                .replaceAll(" ", "");
    }

    private void checkMatcher() {
        if(this.number.matches(".*[a-zA-Z].*"))
            throw new IllegalArgumentException("letters not permitted");

        if(this.number.matches(".*\\p{Punct}.*"))
            throw new IllegalArgumentException("punctuations not permitted");
    }

    private void checkStartsWith() {
        if(this.number.startsWith("0"))
            throw new IllegalArgumentException("area code cannot start with zero");

        if(this.number.startsWith("1"))
            throw new IllegalArgumentException("area code cannot start with one");
    }

    private void checkCharAt() {
        if(this.number.charAt(3) == '0')
            throw new IllegalArgumentException("exchange code cannot start with zero");

        if(this.number.charAt(3) == '1')
            throw new IllegalArgumentException("exchange code cannot start with one");
    }

    private void checkLength() {
        if(this.number.length() < 10)
            throw new IllegalArgumentException("incorrect number of digits");

        if(this.number.length() == 11 && !this.number.startsWith("1"))
            throw new IllegalArgumentException("11 digits must start with 1");

        if(this.number.length() > 10)
            throw new IllegalArgumentException("more than 11 digits");
    }
}