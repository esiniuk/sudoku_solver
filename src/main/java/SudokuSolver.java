import org.openqa.selenium.WebDriver;
import java.util.ArrayList;


public class SudokuSolver {

    private WebDriver driver;
    private SudokuParser sudokuParser;
    private ArrayList<ArrayList<Integer>> verticalVariants;
    private ArrayList<ArrayList<Integer>> horizontalVariants;

    public SudokuSolver (WebDriver driver) {
        this.driver = driver;
        this.sudokuParser = new SudokuParser(driver);
        this.verticalVariants = VerticalVariants();
        this.horizontalVariants = HorizontalVariants();
    }


    private int[][] getMatrix () {
        int[][] sudokuMatrix;
        sudokuMatrix = sudokuParser.ParseSudoku(driver);
        return sudokuMatrix;
    }




    void SolveSudoku() {
        System.out.println(verticalVariants.get(0));
        System.out.println(horizontalVariants.get(0));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (getMatrix()[i][j] == 0) {

                }
            }

        }

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

        for(int k = 0; k < 9; k++) {
            ArrayList<Integer> checklist = CreateCheckList();
            ArrayList<Integer> changedCheckList = CreateCheckList();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++){
                    if (getMatrix()[k][i] == checklist.get(j)) {
                        changedCheckList.remove(checklist.get(j));
                    }
                }
            }
            verticalVariants.add(changedCheckList);
        }
        System.out.println(verticalVariants);
        return verticalVariants;
    }

    private ArrayList<ArrayList<Integer>> HorizontalVariants() {

        ArrayList<ArrayList<Integer>> horizontalVariants = new ArrayList<ArrayList<Integer>>();

        for(int k = 0; k < 9; k++) {
            ArrayList<Integer> checklist = CreateCheckList();
            ArrayList<Integer> changedCheckList = CreateCheckList();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++){
                    if (getMatrix()[i][k] == checklist.get(j)) {
                        changedCheckList.remove(checklist.get(j));
                    }
                }
            }
            horizontalVariants.add(changedCheckList);
        }
        System.out.println(horizontalVariants);
        return horizontalVariants;
    }
//
//    private int SquareChecker() {
//        getMatrix();
//    }
}
