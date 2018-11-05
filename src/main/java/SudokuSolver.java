import org.openqa.selenium.WebDriver;

import java.util.List;

public class SudokuSolver {

    WebDriver driver;

    public SudokuSolver(WebDriver driver) {
        this.driver = driver;
    }

    private SudokuActions sudokuActions = new SudokuActions(driver);
    private SudokuParser sudokuParser = new SudokuParser(driver);

    public int[][] getMatrix () {
        int[][] sudokuMatrix;
        sudokuMatrix = sudokuParser.ParseSudoku(driver);
        return sudokuMatrix;
    }


    public void SolveSudoku() {

        getMatrix();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (getMatrix()[i][0] == 0) {
                // проверка на
                }
            }

        }

    }

    private int[] VerticalChecker() {
        getMatrix();
        for (int i = 0; i < 9; i++) {
            List<Integer> checker = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int j = 0; j < 9; j++){
                if (getMatrix()[0][i] == checker[j]) {
                    //из чекера удаляем повторяющиеся элементы!
                }
            }

        }
    }

    private int HorizontalChecker() {
        getMatrix();
    }

    private int SquareChecker() {
        getMatrix();
    }
}
