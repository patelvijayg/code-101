public class LT572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //if root is null then no way to check is it contains subtree
        if(root == null) return false;
        ///Here root is not null and second tree is null mean Root has null tree of any leaf child hence it is true
        if(subRoot == null) return true;

        //first check both are same tree
        if(isSameTree(root,subRoot)){
            return true;
        }else{
            //if not same tree then go to left and right both child and check if anyone is true
            boolean leftside = isSameTree(root.left,subRoot);
            boolean rightside = isSameTree(root.right,subRoot);
            return leftside||rightside;
        }


    }
    ///https://leetcode.com/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Incase both are null then true
        if(p == null && q == null) return true;
        //Both are not null then check both value  and make recursive call
        if(p !=null && q != null){
            boolean self = p.val == q.val;
            //we can optimise by first check value and if then make recursive call.
            boolean leftside=isSameTree(p.left,q.left);
            boolean rightside=isSameTree(p.right,q.right);
            ///If all 3 codition is true then return true.
            return self && leftside && rightside;
        }else{
            return false;
        }
    }
}
