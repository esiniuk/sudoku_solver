import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SudokuSolver {

    private WebDriver driver;
    private int[][] sudokuMatrix;
    private SudokuParser sudokuParser;
    private SudokuActions sudokuActions;
    private SudokuValidators sudokuValidators;

    public SudokuSolver (WebDriver driver) {
        this.driver = driver;
        this.sudokuParser = new SudokuParser(driver);
        this.sudokuActions = new SudokuActions(driver);
        this.sudokuMatrix = getMatrix();
    }

    private int[][] getMatrix() {
        sudokuMatrix = sudokuParser.ParseSudoku(driver);
        this.sudokuValidators = new SudokuValidators(driver, sudokuMatrix);
        return sudokuMatrix;
    }

    void SolveSudoku() {
        try {
            boolean continueFlag = true;
            while (continueFlag) {
                continueFlag = false;
                getMatrix();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++){
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
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }
}
