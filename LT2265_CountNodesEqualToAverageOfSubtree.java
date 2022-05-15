public class LT2265_CountNodesEqualToAverageOfSubtree {
    //BST Template
    private class Result{
        long sum;
        long count;
        public Result(long sum, long count){
            this.sum=sum;
            this.count=count;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return cnt;
    }
    int cnt=0;
    public Result dfs(TreeNode root){
        if(root == null) return new Result(0,0);
        Result left = dfs(root.left);
        Result right = dfs(root.right);

        long totalsum = left.sum + right.sum + root.val;
        long totalcount = left.count + right.count + 1;
        if(totalsum/totalcount == root.val){
            cnt++;
        }
        return new Result(totalsum,totalcount);
    }
}
