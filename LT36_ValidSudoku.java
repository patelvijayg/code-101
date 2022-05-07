import java.util.HashSet;
import java.util.Set;

public class LT36_ValidSudoku {
    static char[][] matrix=
            {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};

    public static void main(String[] args) {
        boolean isValid=isValidSudoku(matrix);
        System.out.println(isValid);
    }

    public static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char cur=board[i][j];
                if(cur!='.') {
                    String rowSet="R"+i+cur;
                    String colSet="C"+j+cur;
                    String boxSet="B"+i/3+j/3+cur;
                    if(set.contains(rowSet)||set.contains(colSet)||set.contains(boxSet)){
                        return false;
                    }else {
                        set.add(rowSet);
                        set.add(colSet);
                        set.add(boxSet);
                    }
                }
            }
        }
        return true;

    }

}
