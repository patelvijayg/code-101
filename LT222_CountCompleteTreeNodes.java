public class LT222_CountCompleteTreeNodes {


    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        //Get the hight of both side of node. if they equals then it is perfect binary tree(fill all nodes)
        //formula for this kind of tree is 2^height -1 is the node count.
        int leftH=getLeftHeight(root);
        int rightH=getRightHeight(root);

        if(leftH == rightH) {
            int count = (int)Math.pow(2,leftH)-1; // 2^height -1
            return count;
        }else{
            //Incase current node is not perfact binary tree then make the 2 call for child and add one for self
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }
    public int getLeftHeight(TreeNode root){
        if (root==null) return 0;
        int h=0;
        while(root != null){
            h++;
            root=root.left;
        }
        return h;
    }
    public int getRightHeight(TreeNode root){
        if (root==null) return 0;
        int h=0;
        while(root != null){
            h++;
            root=root.right;
        }
        return h;
    }
}
