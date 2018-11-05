import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunSudokuSolver {

    public static void main (String[] agrs){

        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\evgen\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://sudoku.org.ua/rus/");

        SudokuSolver sudokuSolver = new SudokuSolver(driver);
        sudokuSolver.SolveSudoku();
    }
}
