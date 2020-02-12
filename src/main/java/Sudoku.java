import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sudoku {


  public static int [][] board = {
      {0,0,0,0,0,2,1,0,0},
      {0,0,4,0,0,8,7,0,0},
      {0,2,0,3,0,0,9,0,0},
      {6,0,2,0,0,3,0,4,0},
      {0,0,0,0,0,0,0,0,0},
      {0,5,0,6,0,0,3,0,1},
      {0,0,3,0,0,5,0,8,0},
      {0,0,8,2,0,0,5,0,0},
      {0,0,9,7,0,0,0,0,0}
  };

  public static void main(String[] args) {

solve();
printBoard();
System.out.println(isValidBoard(board));
  }


  private static boolean isInRow(int row, int number) {
    for (int i = 0; i < 9; i++)
      if (board[row][i] == number)
        return true;

    return false;
  }

  private static boolean isInCol(int col, int number) {
    for (int i = 0; i < 9; i++)
      if (board[i][col] == number)
        return true;

    return false;
  }

  private static boolean isInBox(int row, int col, int number) {
    int r = row - row % 3;
    int c = col - col % 3;

    for (int i = r; i < r + 3; i++)
      for (int j = c; j < c + 3; j++)
        if (board[i][j] == number)
          return true;

    return false;
  }

  private static boolean isOk(int row, int col, int number) {
    return !isInRow(row, number)  &&  !isInCol(col, number)  &&  !isInBox(row, col, number);
  }

  public static boolean solve() {
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == 0) {
          for (int number = 1; number <= 9; number++) {
            if (isOk(row, col, number)) {
              board[row][col] = number;

              if (solve()) {
                return true;
              } else {
                board[row][col] = 0;
              }
            }
          }

          return false;
        }
      }
    }

    return true;
  }

  private static void printBoard() {
    for (int row = 0; row < 9; row++) {
      for (int column = 0; column < 9; column++) {
        System.out.print(board[row][column] + " ");
      }
      System.out.println();
    }}


  public static boolean isValidBoard (int [][] board){

    int [][] threeByThreeBeingChecked = new int[3][3];

    for (int i = 0; i < 9; i+=3) {
      for (int j = 0; j < 9; j+=3){
        threeByThreeBeingChecked[0][0] = board[i][j];
        threeByThreeBeingChecked[0][1] = board[i][j+1];
        threeByThreeBeingChecked[0][2] = board[i][j+2];

        threeByThreeBeingChecked[1][0] = board[i+1][j];
        threeByThreeBeingChecked[1][1] = board[i+1][j+1];
        threeByThreeBeingChecked[1][2] = board[i+1][j+2];

        threeByThreeBeingChecked[2][0] = board[i+2][j];
        threeByThreeBeingChecked[2][1] = board[i+2][j+1];
        threeByThreeBeingChecked[2][2] = board[i+2][j+2];
        if (!isValid3x3(threeByThreeBeingChecked)){
          return false;
        }
      }
    }

    for (int i = 0; i<9; i++) {
      int [] rowBeingChecked = new int[9];
      int [] colBeingChecked = new int[9];

      for (int j = 0; j<9; j++){
        rowBeingChecked[j] = board [j][i];
        colBeingChecked[j] = board [i][j];
      }

      if (isValidRow(rowBeingChecked) == false || isValidColumn(colBeingChecked) == false){
        return false;
      }
      else return true;
    }




    return true;
  }

  public static boolean isValidRow (int [] row){

    List<Boolean> rowCheck = new ArrayList<>();
     for (int i = 1; i<=row.length; i++){
       rowCheck.add(false);
     }

    for (int i: row){
      if (i != 0) {
        rowCheck.set(i-1, true);
      }
    }

    return rowCheck.stream().allMatch(e -> e);
  }

  public static boolean isValidColumn (int [] column){
    List<Boolean> columnCheck = new ArrayList<>();
    for (int i = 1; i<=column.length; i++){
      columnCheck.add(false);
    }

    for (int i: column){
      if (i != 0) {
        columnCheck.set(i-1, true);
      }
    }

    return columnCheck.stream().allMatch(e -> e);
  }

  public static boolean isValid3x3 (int [][] threeByThree){
    List<Boolean> threeByThreeCheck = new ArrayList<>();
    for (int i = 1; i<=9; i++){
      threeByThreeCheck.add(false);
    }
    for (int i = 0; i<3; i++){
      for (int j = 0; j<3; j++){
        if (threeByThree[i][j] != 0) {
          threeByThreeCheck.set(threeByThree[i][j] - 1, true);
        }
    }
    }
return threeByThreeCheck.stream().allMatch(e -> e);
  }

}
