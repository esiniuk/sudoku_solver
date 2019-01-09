package solvesudoku;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.RunProperties.getSudokuSize;
import static drivers.DriverFactory.driver;

public class SudokuSolver {

    private SudokuParser sudokuParser = new SudokuParser();
    private SudokuActions sudokuActions = new SudokuActions();

    public void SolveSudoku() {
        int sudokuSize = getSudokuSize();
        int[][] sudokuMatrix;
        SudokuValidators sudokuValidators;
        try {
            boolean continueFlag = true;
            while (continueFlag) {
                continueFlag = false;
                sudokuMatrix = getMatrix();
                sudokuValidators = new SudokuValidators(getMatrix());
                for (int i = 0; i < sudokuSize; ++i) {
                    for (int j = 0; j < sudokuSize; ++j){
                        if (sudokuMatrix[i][j] == 0 && sudokuValidators.Answer(i, j) != null) {
                            sudokuActions.ChoseNumber(i, j, sudokuValidators.Answer(i, j));
                            continueFlag = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            checkAlert();
        }
    }

    private void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("You solve sudoku!");
        } catch (Exception e) {
            System.err.println("There is no winning notification!");
        }
    }

    private int[][] getMatrix() {

        return sudokuParser.ParseSudoku();
    }
}
