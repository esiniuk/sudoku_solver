import solvesudoku.SudokuSolver;
import ui.StartPage;

public class RunSudokuSolver {

    private static StartPage startPage = new StartPage();
    private static SudokuSolver sudokuSolver = new SudokuSolver();

    public static void main (String[] agrs){

        startPage.open();
        sudokuSolver.SolveSudoku();
        startPage.close();

    }
}
