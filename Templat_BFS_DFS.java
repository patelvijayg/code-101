import java.util.*;

public class Templat_BFS_DFS {

    public void bfs(TreeNode root){
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int sum=0;
        int level=0;
        while(q.size()>0){
            int child = q.size();
            level++;
            for(int i=0; i< child; i++){
                TreeNode curr = q.remove();
                //do processing of picked element
                sum=sum + curr.val;
                //Adding the childrens to queue if exists
                if(curr.left !=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

            }

        }
    }
    public void bfsingrid(int[][] grid){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(grid[0]);
        int sum=0;
        int level=0;
        int m=grid.length,n=grid[0].length;
        while(q.size()>0){
            int child = q.size();
            level++;
            for(int i=0; i< child; i++){
                int[] curr = q.remove();
                //4 direction
                int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
                for (int[] dir : directions){
                    int newi = curr[0] + dir[0];
                    int newj = curr[1] + dir[1];
                    if(newi<0 || newi>m || newj<0 || newj>n || grid[newi][newj] != 1){
                        continue;
                    }
                    q.add(new int[]{1,2});

                }

            }
        }
    }
}
