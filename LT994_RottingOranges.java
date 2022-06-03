import java.util.*;

public class LT994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        class Rotan{
            int i;
            int j;
            int time;
            public Rotan(int i, int j, int time) {
                this.i = i;
                this.j = j;
                this.time = time;
            }


        }
        int m=grid.length, n=grid[0].length;

        Queue<Rotan> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==2){
                    Rotan r = new Rotan(i,j,0);
                    queue.add(r);
                }
            }
        }
        int rotantime=0;
        while (queue.size()>0){
            Rotan curr = queue.remove();
            //4 direction
            int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            for (int[] dir : directions){
                int newi = curr.i + dir[0];
                int newj = curr.j + dir[1];
                if(newi<0 || newi>m || newj<0 || newj>n || grid[newi][newj] != 1){
                    continue;
                }
                grid[newi][newj]=2;
                queue.add(new Rotan(newi,newj, curr.time+1));

            }
            rotantime=curr.time;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }


        return rotantime;
    }
}
