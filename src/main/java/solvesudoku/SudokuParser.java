package solvesudoku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.DriverFactory.driver;
import static utils.RunProperties.getSudokuSize;

public class SudokuParser {

    public int[][] ParseSudoku(){

        int sudokuSize = getSudokuSize();
        int [][] sudokumatrix = new int[sudokuSize][sudokuSize];
        for (int i = 0; i < sudokuSize; ++i) {
            for (int j = 0; j < sudokuSize; ++j) {
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
