package solvesudoku;

import org.openqa.selenium.By;
import static drivers.DriverFactory.driver;

public class SudokuActions {

    private String IDBase (int i, int j) {

        return ("td" + String.valueOf(i) + String.valueOf(j));
    }

    public void ChoseNumber (int i, int j, String reqNumber){
        By reqCell = By.id(IDBase(i, j));
        By reqNum = By.xpath("//*[@id='numz']/a[" + reqNumber +"]");
        driver.findElement(reqCell).click();
        driver.findElement(reqNum).click();

    }

}
