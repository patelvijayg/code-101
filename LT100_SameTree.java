public class LT100_SameTree {

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
