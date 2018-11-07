import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SudokuActions {

    private WebDriver driver;

    public SudokuActions(WebDriver driver) {
        this.driver = driver;
    }

    private String IDBase (int i, int j) {
        String cellNumber = "td" + String.valueOf(i) + String.valueOf(j);
        return cellNumber;
    }


    public void ChoseNumber (int i, int j, String reqNumber){
        By reqCell = By.id(IDBase(i, j));
        By reqNum = By.xpath("//*[@id='numz']/a[" + reqNumber +"]");
        driver.findElement(reqCell).click();
        driver.findElement(reqNum).click();

    }

}
