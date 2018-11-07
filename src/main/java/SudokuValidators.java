import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SudokuValidators {

    private WebDriver driver;
    private SudokuParser sudokuParser;
    private ArrayList<ArrayList<Integer>> verticalVariants;
    private ArrayList<ArrayList<Integer>> horizontalVariants;
    private ArrayList<ArrayList<Integer>> boxVariants;
    private int[][] sudokuMatrix;


    public SudokuValidators(WebDriver driver) {
        this.driver = driver;
        this.sudokuParser = new SudokuParser(driver);
        this.sudokuMatrix = getMatrix();
        this.verticalVariants = VerticalVariants();
        this.horizontalVariants = HorizontalVariants();
        this.boxVariants = BoxVariants();
    }


    private int[][] getMatrix() {
        sudokuMatrix = sudokuParser.ParseSudoku(driver);
        return sudokuMatrix;
    }


    private ArrayList<Integer> CreateCheckList() {
        ArrayList<Integer> checkList = new ArrayList<Integer>();
        for (int x = 1; x <= 9; x++) {
            checkList.add(x);
        }
        return checkList;
    }


    private ArrayList<ArrayList<Integer>> VerticalVariants() {
        ArrayList<ArrayList<Integer>> verticalVariants = new ArrayList<ArrayList<Integer>>();
        for (int k = 0; k < 9; k++) {
            ArrayList<Integer> checklist = CreateCheckList();
            ArrayList<Integer> changedCheckList = CreateCheckList();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudokuMatrix[k][i] == checklist.get(j)) {
                        changedCheckList.remove(checklist.get(j));
                    }
                }
            }
            verticalVariants.add(changedCheckList);
        }
        return verticalVariants;
    }


    private ArrayList<ArrayList<Integer>> HorizontalVariants() {
        ArrayList<ArrayList<Integer>> horizontalVariants = new ArrayList<ArrayList<Integer>>();
        for (int k = 0; k < 9; k++) {
            ArrayList<Integer> checklist = CreateCheckList();
            ArrayList<Integer> changedCheckList = CreateCheckList();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudokuMatrix[i][k] == checklist.get(j)) {
                        changedCheckList.remove(checklist.get(j));
                    }
                }
            }
            horizontalVariants.add(changedCheckList);
        }
        return horizontalVariants;
    }

    public ArrayList<ArrayList<Integer>> BoxVariants() {
        ArrayList<ArrayList<Integer>> boxVariants = new ArrayList<ArrayList<Integer>>();
        for (int x = 0; x < 9; x = x + 3)  {
            ArrayList<Integer> checklist = CreateCheckList();
            ArrayList<Integer> changedCheckList = CreateCheckList();
            for (int k = x; k < (x + 3) ; k++) {
                for (int i = x; i < (x+3); i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.println(i + " " + k);
                        if (sudokuMatrix[i][k] == checklist.get(j)) {
                            changedCheckList.remove(checklist.get(j));
                        }
                    }
                }

            }
            System.out.println("xyi");
            boxVariants.add(changedCheckList);
        }
        return boxVariants;
    }
}