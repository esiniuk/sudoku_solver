import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SudokuValidators {

    private WebDriver driver;
    private SudokuParser sudokuParser;
    private ArrayList<ArrayList<Integer>> verticalVariants;
    private ArrayList<ArrayList<Integer>> horizontalVariants;
    private ArrayList<ArrayList<Integer>> boxVariants;
    private int[][] sudokuMatrix;


    public SudokuValidators(WebDriver driver, int[][] sudokuMatrix) {
        this.driver = driver;
        this.sudokuParser = new SudokuParser(driver);
        this.sudokuMatrix = sudokuMatrix;
        this.verticalVariants = VerticalVariants();
        this.horizontalVariants = HorizontalVariants();
        this.boxVariants = BoxVariants();
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

    private ArrayList<ArrayList<Integer>> BoxVariants() {
        ArrayList<ArrayList<Integer>> boxVariants = new ArrayList<ArrayList<Integer>>();
        for (int x = 0; x < 9; x = x + 3)  {
            ArrayList<Integer> checklist = CreateCheckList();
            ArrayList<Integer> changedCheckList = CreateCheckList();
            for (int k = 0; k < 3 ; k++) {
                for (int i = x; i < (x + 3); i++) {
                    for (int j = 0; j < 9; j++) {
                        if (sudokuMatrix[i][k] == checklist.get(j)) {
                            changedCheckList.remove(checklist.get(j));
                        }
                    }
                }

            }
            boxVariants.add(changedCheckList);
            checklist = CreateCheckList();
            changedCheckList = CreateCheckList();
            for (int k = 3; k < 6 ; k++) {
                for (int i = x; i < (x + 3); i++) {
                    for (int j = 0; j < 9; j++) {
                        if (sudokuMatrix[i][k] == checklist.get(j)) {
                            changedCheckList.remove(checklist.get(j));
                        }
                    }
                }

            }
            boxVariants.add(changedCheckList);
            checklist = CreateCheckList();
            changedCheckList = CreateCheckList();
            for (int k = 6; k < 9 ; k++) {
                for (int i = x; i < (x + 3); i++) {
                    for (int j = 0; j < 9; j++) {
                        if (sudokuMatrix[i][k] == checklist.get(j)) {
                            changedCheckList.remove(checklist.get(j));
                        }
                    }
                }

            }
            boxVariants.add(changedCheckList);
        }
        return boxVariants;
    }

    private ArrayList<ArrayList<String>> BoxLocator() {
        ArrayList<ArrayList<String>> boxLocator = new ArrayList<ArrayList<String>>();
        for (int x = 0; x < 9; x = x + 3)  {
            ArrayList<String> boxKeys = new ArrayList<String>();
            for (int k = 0; k < 3 ; k++) {
                for (int i = x; i < (x + 3); i++) {
                    boxKeys.add(i + "" + k);
                    }
                }
            boxLocator.add(boxKeys);
            boxKeys = new ArrayList<String>();
            for (int k = 3; k < 6 ; k++) {
                for (int i = x; i < (x + 3); i++) {
                    boxKeys.add(i + "" + k);
                }
            }
            boxLocator.add(boxKeys);
            boxKeys = new ArrayList<String>();
            for (int k = 6; k < 9 ; k++) {
                for (int i = x; i < (x + 3); i++) {
                    boxKeys.add(i + "" + k);
                }
            }
            boxLocator.add(boxKeys);
        }
        return boxLocator;
    }

    private int BoxFinder(int i, int j) {
        int boxID = 0;
        for (int k = 0; k < 9; k++) {
            for (int x = 0; x < 9; x++) {
                String checker = String.valueOf(i) + "" + String.valueOf(j);
                if (checker.equals(BoxLocator().get(k).get(x))) {
                    boxID = k;
                }
            }
        }
        return boxID;
    }

    public String Answer (int i, int j) {
        String answer = null;
        ArrayList <Integer> variants = new ArrayList<Integer>();
        for (int x = 0; x < VerticalVariants().get(i).size(); x++) {
            for (int k = 0; k < HorizontalVariants().get(j).size(); k++) {
                if (VerticalVariants().get(i).get(x).equals(HorizontalVariants().get(j).get(k))) {
                    for (int y = 0; y < BoxVariants().get(BoxFinder(i, j)).size(); y++) {
                        if (HorizontalVariants().get(j).get(k).equals(BoxVariants().get(BoxFinder(i, j)).get(y))) {
                            variants.add(BoxVariants().get(BoxFinder(i, j)).get(y));
                        }
                    }
                }
            }
        }
        if (variants.size() == 1) {
            answer = String.valueOf(variants.get(0) + 3);
        }
        return answer;
    }
}