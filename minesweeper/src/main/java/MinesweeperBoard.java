import java.util.List;
import java.util.ArrayList;
public class MinesweeperBoard {
    private final List<String> unscoredBoard;
    private int[][] scoredBoard;
    private int rows;
    private int cols;

    public MinesweeperBoard(List<String> unscoredBoard) {
        this.unscoredBoard = unscoredBoard;
    }
    public List<String> withNumbers() {
        scoreBoard();

        List<String> boardWithNumbers = new ArrayList<>();
        for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
            StringBuilder rowBuilder = new StringBuilder();

            for (int colIdx = 0; colIdx < cols; colIdx++) {

                int countOrMine = scoredBoard[rowIdx][colIdx];
                char square = ' ';

                if (countOrMine == -1)
                    square = '*';

                else if (countOrMine > 0)
                    square = (char) (countOrMine + '0');

                rowBuilder.append(square);
            }
            boardWithNumbers.add(rowBuilder.toString());
        }
        return boardWithNumbers;
    }
    private void addMineCountToNeighbours(int rowIdx, int colIdx) {
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int colOffset = -1; colOffset <= 1; colOffset++) {

                int newRowIdx = rowIdx + rowOffset;
                int newColIdx = colIdx + colOffset;

                if (newRowIdx < 0 || newRowIdx >= rows || newColIdx < 0 || newColIdx >= cols)
                    continue;

                if (scoredBoard[newRowIdx][newColIdx] == -1)
                    continue;

                scoredBoard[newRowIdx][newColIdx]++;
            }
        }
    }
    private void scoreBoard() {
        if (this.unscoredBoard == null || this.unscoredBoard.size() == 0)
            return;

        this.rows = unscoredBoard.size();
        this.cols = unscoredBoard.get(0).length();
        scoredBoard = new int[rows][cols];

        for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
            String row = unscoredBoard.get(rowIdx);

            for (int colIdx = 0; colIdx < cols; colIdx++) {
                char square = row.charAt(colIdx);
                scoredBoard[rowIdx][colIdx] = square == ' ' ? 0 : -1;
            }
        }

        for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
            for (int colIdx = 0; colIdx < cols; colIdx++) {

                if (scoredBoard[rowIdx][colIdx] == -1)
                    addMineCountToNeighbours(rowIdx, colIdx);
            }
        }
    }
}