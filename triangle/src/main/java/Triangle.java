class Triangle {
    private final boolean IS_EQUILATERAL;
    private final boolean IS_ISOSCELES;
    private final boolean IS_SCALENE;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        if(side1 ==  0 || side2 == 0 || side3 == 0) throw new TriangleException("Not a Triangle");

        if(
                (side1 + side2 <= side3) ||
                (side2 + side3 <= side1) ||
                (side3 + side1 <= side2)

        ) throw new TriangleException("Not a Triangle");


        IS_EQUILATERAL = (side1 == side2 &&  side1 == side3);

        IS_ISOSCELES = (side1 - side2 == 0) ||
                       (side1 - side3 == 0) ||
                       (side2 - side3 == 0);


        IS_SCALENE = !IS_EQUILATERAL && !IS_ISOSCELES;

    }

    public boolean isEquilateral() { return IS_EQUILATERAL; }
    boolean isIsosceles() { return IS_ISOSCELES; }
    boolean isScalene() { return IS_SCALENE; }

}
