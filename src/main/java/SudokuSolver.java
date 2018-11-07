import org.openqa.selenium.WebDriver;
import java.util.ArrayList;


public class SudokuSolver {

    private WebDriver driver;
    private int[][] sudokuMatrix;
    private SudokuParser sudokuParser;
    private ArrayList<ArrayList<Integer>> boxVariants;
    private SudokuValidators sudokuValidators;

    public SudokuSolver (WebDriver driver) {
        this.driver = driver;
        this.sudokuParser = new SudokuParser(driver);
        this.sudokuValidators = new SudokuValidators(driver);
        this.sudokuMatrix = getMatrix();
        this.boxVariants = getBoxes();
    }

    private int[][] getMatrix() {
        sudokuMatrix = sudokuParser.ParseSudoku(driver);
        return sudokuMatrix;
    }

    private ArrayList<ArrayList<Integer>> getBoxes() {
        boxVariants = sudokuValidators.BoxVariants();
        return boxVariants;
    }

    void SolveSudoku() {
        System.out.println(boxVariants);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (sudokuMatrix[i][j] == 0) {

                }
            }

        }

    }



//
//    private int SquareChecker() {
//        getMatrix();
//    }
}
