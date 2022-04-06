class Matrix {

    private final String matrixAsString;

    Matrix(String matrixAsString) { this.matrixAsString = matrixAsString; }

    int[] getRow(int rowNumber) {
        if(matrixAsString.length() == 1) return new int[]{Integer.parseInt(this.matrixAsString)};

        String[] stringRow = matrixAsString.split("\n");
        String[] stringMatrixOrder = stringRow[rowNumber-1].split(" ");

        int[] rowInt = new int[stringMatrixOrder.length];

        for (int i = 0; i < stringMatrixOrder.length; i++) { rowInt[i] = Integer.parseInt(stringMatrixOrder[i]); }

        return rowInt;
    }

    int[] getColumn(int columnNumber) {
        if(matrixAsString.length() == 1) return new int[]{Integer.parseInt(this.matrixAsString)};

        String[] stringRow = matrixAsString.split("\n");
        int[] valuesColum = new int[3];


        for (int i = 0; i < stringRow.length; i++) {
            String[] arraySplintedWithSpace = stringRow[i].split(" ");

            valuesColum[i] = Integer.parseInt(arraySplintedWithSpace[columnNumber-1]);

        }

        return valuesColum;
    }
}
