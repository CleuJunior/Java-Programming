public class Hamming {

    private String leftStrand;
    private String rightStrand;
    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        StrandsExceptions(leftStrand, rightStrand);
    }

    private void StrandsExceptions(String leftStrand, String rightStrand) {
        if(rightStrand.length() < 1 && leftStrand.length() != 0)
            throw new IllegalArgumentException("right strand must not be empty.");

        if(leftStrand.length() < 1  && rightStrand.length() != 0)
            throw new IllegalArgumentException("left strand must not be empty.");

        if(leftStrand.length() != rightStrand.length())
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
    }

    public int getHammingDistance() {
        if(leftStrand.equals(rightStrand)) return 0;
        int countDiffs = 0;

        for (int i = 0; i < leftStrand.length(); i++) { if(leftStrand.charAt(i) != rightStrand.charAt(i)) countDiffs+=1; }

        return countDiffs;
    }
}
