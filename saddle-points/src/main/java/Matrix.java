import java.util.List;
import java.util.Set;
import java.util.HashSet;
class Matrix {
    private final List<List<Integer>> matrix;
    private final int rows;
    private final int cols;
    private final int[] rowsMax;
    private final int[] colsMin;

    public Matrix(List<List<Integer>> values) {
        matrix = values;
        rows = values.size();
        cols = rows == 0 ? 0 : values.get(0).size();
        rowsMax = new int[rows];
        colsMin = new int[cols];

        for(int i = 0; i < cols; i++)
            colsMin[i] = Integer.MAX_VALUE;


        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++) {
                if(matrix.get(i).get(j) > rowsMax[i])
                    rowsMax[i] = matrix.get(i).get(j);

                if(matrix.get(i).get(j) < colsMin[j])
                    colsMin[j] = matrix.get(i).get(j);
            }
    }
    public Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(matrix.get(i).get(j) >= rowsMax[i] && matrix.get(i).get(j) <= colsMin[j])
                    saddlePoints.add(new MatrixCoordinate(i+1, j+1));

        return saddlePoints;
    }
}