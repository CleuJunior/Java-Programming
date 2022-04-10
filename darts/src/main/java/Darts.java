class Darts {

    private final double TOTAL_TARGET;

    public Darts(double x, double y) { TOTAL_TARGET = Math.sqrt(x*x + y*y); }

    public int score() {
        return  TOTAL_TARGET <= 1 ? 10 :
                TOTAL_TARGET <= 5 ? 5 :
                TOTAL_TARGET <= 10 ? 1 :
                0;
    }

}
