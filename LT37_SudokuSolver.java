import java.util.Arrays;

public class LT37_SudokuSolver {
    public static void main(String[] args) {
        char[][] b = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        LT37_SudokuSolver driver = new LT37_SudokuSolver();
        driver.solveSudoku(b);
        System.out.println(Arrays.deepToString(b));

    }
    public  void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char k='1'; k<='9'; k++){
                        if(isvalid(i,j,k,board)){
                            board[i][j]=k;
                            if(solve(board)==true){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }

                    }
                    //return false if for loop is completed and not return true
                    return false;
                }
            }
        }

        //if entire sudoku is filled.
        return true;
    }


    public boolean isvalid(int r, int c, char num,char[][] board){

        for(int i=0; i<9; i++){
            if(board[r][i] == num ) return false;
            if(board[i][c] == num ) return false;
            int boxrow= (r/3)*3 + i/3;
            int boxcol=(c/3)*3 + i%3;
            if(board[boxrow][boxcol]==num) return false;

        }
        return true;
    }
}
