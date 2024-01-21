class CalculatorConundrum {

    private int operand1;
    private int operand2;
    private String operation;
    private static final String PLUS =  "+";
    private static final String MINUS =  "-";
    private static final String TIMES =  "*";
    private static final String DIVISION =  "/";
    private static final String EQUALS_SING =  " = ";
    private static final String BLANK_SPACE =  " ";
    public static final String OPERATION_CANNOT_BE_NULL = "Operation cannot be null";
    public static final String OPERATION_CANNOT_BE_EMPTY = "Operation cannot be empty";
    public static final String DIVISION_BY_ZERO_IS_NOT_ALLOWED = "Division by zero is not allowed";
    public static final String OPERATION_DOES_NOT_EXIST = "Operation '%s' does not exist";

    public String calculate(int operand1, int operand2, String operation) {
        this.baseValidations(operation);
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;

        int result = this.baseOperation();
        return operand1 + BLANK_SPACE + operation + BLANK_SPACE + operand2 + EQUALS_SING + result;
    }

    private void baseValidations(String operation) {
        if (operation == null) {
            throw new IllegalArgumentException(OPERATION_CANNOT_BE_NULL);
        }

        if (operation.isEmpty()) {
            throw new IllegalArgumentException(OPERATION_CANNOT_BE_EMPTY);
        }
    }

    private int baseOperation() {
        return this.plus();
    }

    private int plus(){
        if(!this.operation.equals(PLUS)) {
            return minus();
        }

        return this.operand1 + this.operand2;
    }

    private int minus(){
        if(!this.operation.equals(MINUS)) {
            return this.times();
        }

        return this.operand1 - this.operand2;
    }

    private int times(){
        if(!this.operation.equals(TIMES)) {
            return this.division();
        }

        return this.operand1 * this.operand2;
    }

    private int division(){
        this.finalValidation();
        if (this.operand2 == 0) {
            throw new IllegalOperationException(DIVISION_BY_ZERO_IS_NOT_ALLOWED, new ArithmeticException());
        }

        return this.operand1 / this.operand2;
    }

    private void finalValidation() {
        if(!this.operation.equals(DIVISION))
            throw new IllegalOperationException(String.format(OPERATION_DOES_NOT_EXIST, this.operation));
    }
}
