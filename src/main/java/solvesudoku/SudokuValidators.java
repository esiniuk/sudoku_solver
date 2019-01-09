package solvesudoku;

import java.util.ArrayList;

import static utils.RunProperties.getSudokuSize;

public class SudokuValidators {

    private int[][] sudokuMatrix;
    private int sudokuSize = getSudokuSize();
    private ArrayList<Integer> checkList = CreateCheckList();

    public SudokuValidators(int[][] sudokuMatrix) {
        this.sudokuMatrix = sudokuMatrix;
    }
    private ArrayList<Integer> CreateCheckList() {
        ArrayList<Integer> checkList = new ArrayList<Integer>();
        for (int x = 1; x <= sudokuSize; ++x) {
            checkList.add(x);
        }
        return checkList;
    }

    private ArrayList<ArrayList<Integer>> lineVariants(String direction) {
        ArrayList<ArrayList<Integer>> lineVariants = new ArrayList<ArrayList<Integer>>();
        for (int k = 0; k < sudokuSize; ++k) {
            ArrayList<Integer> changedCheckList = CreateCheckList();
            for (int i = 0; i < sudokuSize; ++i) {
                for (int j = 0; j < sudokuSize; ++j) {
                    if (direction.equals("vertical")) {
                        if (sudokuMatrix[k][i] == checkList.get(j)) {
                            changedCheckList.remove(checkList.get(j));
                        }
                    } else if (direction.equals("horizontal")) {
                        if (sudokuMatrix[i][k] == checkList.get(j)) {
                            changedCheckList.remove(checkList.get(j));

                        }
                    } else {
                        System.err.println("Unknown direction!");
                    }
                }
            }
            lineVariants.add(changedCheckList);
        }
        return lineVariants;
    }

    private ArrayList<ArrayList<Integer>> BoxVariants() {
        ArrayList<ArrayList<Integer>> boxVariants = new ArrayList<ArrayList<Integer>>();
        for (int x = 0; x < sudokuSize; x = x + 3)  {
            ArrayList<Integer> changedCheckList;
            for (int y = 0; y < sudokuSize; y = y + 3) {
                changedCheckList = CreateCheckList();
                for (int k = y; k < y + 3; ++k) {
                    for (int i = x; i < x + 3; ++i) {
                        for (int j = 0; j < sudokuSize; ++j) {
                            if (sudokuMatrix[i][k] == checkList.get(j)) {
                                changedCheckList.remove(checkList.get(j));
                            }
                        }
                    }
                }
                boxVariants.add(changedCheckList);
            }
        }
        return boxVariants;
    }

    private ArrayList<ArrayList<String>> BoxLocator() {
        ArrayList<ArrayList<String>> boxLocator = new ArrayList<ArrayList<String>>();
        for (int x = 0; x < sudokuSize; x = x + 3)  {
            ArrayList<String> boxKeys;
            for (int y = 0; y < sudokuSize; y = y + 3) {
                boxKeys = new ArrayList<String>();
                for (int k = y; k < y + 3; ++k) {
                    for (int i = x; i < x + 3; ++i) {
                        boxKeys.add(i + "" + k);
                    }
                }
                boxLocator.add(boxKeys);
            }
        }
        return boxLocator;
    }

    private int BoxFinder(int i, int j) {
        int boxID = 0;
        for (int k = 0; k < sudokuSize; ++k) {
            for (int x = 0; x < sudokuSize; ++x) {
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
        for (int x = 0; x < lineVariants("vertical").get(i).size(); ++x) {
            for (int k = 0; k < lineVariants("horizontal").get(j).size(); ++k) {
                if (lineVariants("vertical").get(i).get(x).equals(lineVariants("horizontal").get(j).get(k))) {
                    for (int y = 0; y < BoxVariants().get(BoxFinder(i, j)).size(); ++y) {
                        if (lineVariants("horizontal").get(j).get(k).equals(BoxVariants().get(BoxFinder(i, j)).get(y))) {
                            variants.add(BoxVariants().get(BoxFinder(i, j)).get(y));
                        }
                    }
                }
            }
        }
        if (variants.size() == 1) {
            answer = String.valueOf(variants.get(0) + 3); //+3 because of incorrect id on page
        }
        return answer;
    }
}