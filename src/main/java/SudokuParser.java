import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class SudokuParser {

    private WebDriver driver;

    SudokuParser(WebDriver driver) { this.driver = driver; }

    int[][] ParseSudoku(WebDriver driver){

        int [][] sudokumatrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String cellNumber = "td" + String.valueOf(i) + String.valueOf(j);
                WebElement element = driver.findElement(By.id(cellNumber));
                String attribute = element.getAttribute("innerHTML");
                int x = Integer.parseInt(attribute.substring(14,15));
                sudokumatrix[i][j] = x;
             }
        }
        return sudokumatrix;
    }
}
