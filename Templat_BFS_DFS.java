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
}
