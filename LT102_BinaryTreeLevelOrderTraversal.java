import java.util.*;

public class LT102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  allNodesList = new ArrayList<>();
        if(root == null) return allNodesList;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelChildren = new ArrayList();
            for(int i=0; i < size; i++){
                TreeNode curr = queue.poll();
                levelChildren.add(curr.val);
                //First add the left child and then right as it is queue
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            allNodesList.add(levelChildren);
        }

        return allNodesList;
    }
}
