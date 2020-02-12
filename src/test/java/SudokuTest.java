import static org.junit.Assert.*;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

import static org.hamcrest.core.Is.is;

import java.util.List;
import org.junit.Test;

import org.junit.Test;

public class SudokuTest {

  @Test
  public void isValidBoardTest() {
    int [][] validBoard = {
        {8,2,5,4,7,1,3,9,6},
        {1,9,4,3,2,6,5,7,8},
        {3,7,6,9,8,5,2,4,1},
        {5,1,9,7,4,3,8,6,2},
        {6,3,2,5,9,8,4,1,7},
        {4,8,7,6,1,2,9,3,5},
        {2,6,3,1,5,9,7,8,4},
        {9,4,8,2,6,7,1,5,3},
        {7,5,1,8,3,4,6,2,9}
    };

    int [][] invalidBoard = {
        {8,2,5,4,7,1,3,9,8},
        {0,9,4,3,2,6,5,7,8},
        {3,7,6,9,8,5,2,4,1},
        {0,1,9,7,4,3,0,6,2},
        {6,3,2,5,9,8,4,1,7},
        {0,8,7,6,1,2,9,3,5},
        {2,6,3,1,5,8,7,8,4},
        {9,4,8,2,6,7,1,5,3},
        {7,5,1,8,3,4,0,0,9}
    };

    assertThat(Sudoku.isValidBoard(validBoard), is(true));

    assertThat(Sudoku.isValidBoard(invalidBoard), is(false));
  }

  @Test
  public void isValidRowTest() {
    int [] row = {1,2,3,4,5,6,7,8,9};
    int [] row2 = {5,4,6,3,7,2,8,9,1};

    int [] badRowEmptyCellsAndDuplicates = {0,0,1,2,3,4,1,2,3};
    int [] badRowDuplicatesOnly =  {1,1,1,2,2,3,4,5,5};
    int [] badRowAllEmptyCells = {0,0,0,0,0,0,0,0,0};

    assertThat(Sudoku.isValidRow(row), is(true));
    assertThat(Sudoku.isValidRow(row2), is (true));

    assertThat(Sudoku.isValidRow(badRowEmptyCellsAndDuplicates), is(false));
    assertThat(Sudoku.isValidRow(badRowDuplicatesOnly), is(false));
    assertThat(Sudoku.isValidRow(badRowAllEmptyCells), is(false));
  }

  @Test
  public void isValidColumnTest() {
    int [] column = {1,2,3,4,5,6,7,8,9};
    int [] column2 = {5,4,6,3,7,2,8,9,1};

    int [] badColumnEmptyCellsAndDuplicates = {0,0,1,2,3,4,1,2,3};
    int [] badColumnDuplicatesOnly =  {1,1,1,2,2,3,4,5,5};
    int [] badColumnAllEmptyCells = {0,0,0,0,0,0,0,0,0};

    assertThat(Sudoku.isValidColumn(column), is(true));
    assertThat(Sudoku.isValidColumn(column2), is (true));

    assertThat(Sudoku.isValidColumn(badColumnEmptyCellsAndDuplicates), is(false));
    assertThat(Sudoku.isValidColumn(badColumnDuplicatesOnly), is(false));
    assertThat(Sudoku.isValidColumn(badColumnAllEmptyCells), is(false));
  }

  @Test
  public void isValid3x3Test() {
    int [][] goodThreeByThree = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };

    int [][] goodRandomOrderThreeByThree = {
        {4,7,9},
        {1,3,8},
        {2,5,6}
    };

    int [][] badEmptyCellsAndDuplicates = {
        {0,0,1},
        {0,2,2},
        {0,3,3}
    };

    int [][] badEmptyCells = {
        {0,0,0},
        {0,0,0},
        {0,0,0}
    };

    int [][] badDuplicatesOnly = {
        {2,2,2},
        {9,9,1},
        {3,3,1}
    };

    assertThat(Sudoku.isValid3x3(goodThreeByThree), is(true));
    assertThat(Sudoku.isValid3x3(goodRandomOrderThreeByThree), is(true));

    assertThat(Sudoku.isValid3x3(badEmptyCellsAndDuplicates), is(false));
    assertThat(Sudoku.isValid3x3(badEmptyCells), is(false));
    assertThat(Sudoku.isValid3x3(badDuplicatesOnly), is(false));
  }
}