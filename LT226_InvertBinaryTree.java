public class LT226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        //If root is null then return null or root
        if(root == null) return root;
        //Get the leftside and rightside of tree and store in variable
        TreeNode leftside = invertTree(root.left);
        TreeNode rightside = invertTree(root.right);
        //assign root.left member as rightside and vice versa
        root.left=rightside;
        root.right=leftside;
        //return the updated root which has swapped left and right sides
        return root;
    }
}
