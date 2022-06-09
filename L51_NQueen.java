import java.util.*;

public class L51_NQueen {

    public static void main(String[] args) {
        L51_NQueen driver= new L51_NQueen();
        List<List<String>> solution=driver.solveNQueens(10);
        System.out.println(solution);
    }
    private boolean[] left,  topLeft ,bottomLeft;
    public List<List<String>> solveNQueens(int n) {
        //fill the all cell with . and try to place Q on one by one cell and validate
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chess[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();

        //these are used for valid position and we will be populate these after each placement
        //there will be 3 boolean true in each array denotes place has been fill
        //and next placement if anyone of them is true then it is not valid placement
        int sizeDiag=2*n;
        left=new boolean[n];
        topLeft=new boolean[sizeDiag];
        bottomLeft=new boolean[sizeDiag];

        solve(0,ans,n,chess);
        return ans;
    }
    public void solve(int col, List<List<String>> ans, int n,char[][] chess ){
        if(col==n){
            //if we reach here mean it is valid placement and it is last column so we can store this value in result
            List<String> temp=new ArrayList<>();
            for(char[] ca:chess){
                temp.add(new String(ca));
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        //we have to start with 0th row to n and check where can we place queen
        for (int row = 0; row < n; row++) {
            //check it is valid placement.
            if(isValid(row,col,n)){
                //since it is valid placement we must need to set flags so next call will not use this position
                setFlags(row,col,true,n);
                chess[row][col]='Q';

                solve(col+1,ans,n,chess);
                //backtrace we must need to clear flag set before recursion call so it will be used for other combination
                chess[row][col]='.';
                setFlags(row,col,false,n);
            }

        }


    }
    public void setFlags(int row, int col,boolean isUsed,int n){
            //left index simple the row
            //ideally (row+col) will give you diagonal but if we cross diagonal then we need to subtract from N
            //diagonal of top will be N-(row+col). we will deduct from n because value range from 0 to 2n
            //diagonal of Bottom will be (row+col) simple
            int topDiag=Math.abs(n-row+col), bottomDiag=row+col, leftDiag=row;
            left[leftDiag]=topLeft[topDiag]=bottomLeft[bottomDiag]=isUsed;
    }
    public boolean isValid(int row,int col,int n){
        int topDiag=Math.abs(n-row+col), bottomDiag=row+col, leftDiag=row;
        //System.out.println("row="+row+" col="+col + " topd="+topDiag+" botomd="+bottomDiag+" leftd="+leftDiag);

        if(left[leftDiag]==false && topLeft[topDiag]==false &&  bottomLeft[bottomDiag]==false)
            return true;
        else
            return false;
    }
}
