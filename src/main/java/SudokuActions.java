import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SudokuActions {

    private WebDriver driver;

    public SudokuActions(WebDriver driver) {
        this.driver = driver;
    }

    private String[][] IDBase () {
        String[][] cellNumber = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String cellID = "td" + String.valueOf(i) + String.valueOf(j);
                cellNumber[i][j] = cellID;
            }
        }
        return cellNumber;
    }


    public void ChoseNumber (String cell, String reqNumber){
        By reqCell = By.id(cell);
        By reqNum = By.xpath("//*[@id='numz']/a[" + reqNumber +"]");
        driver.findElement(reqCell).click();
        driver.findElement(reqNum).click();

    }

}
