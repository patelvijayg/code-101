import java.util.ArrayList;
import java.util.List;

public class PracticeBinaryTree {
    public static void main(String[] args) {
        PracticeBinaryTree driver = new PracticeBinaryTree();
        TreeNode r1 = new TreeNode(600);
        TreeNode r2 = new TreeNode(300);
        TreeNode r3 = new TreeNode(200);
        r1.left=r2; r1.right=r3;
        r2.left=new TreeNode(400);
        double mxavg=driver.getMaxAvg(r1);
        System.out.println(" node=" + maxRoot.val +  "  avg="+mxavg  );
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2){
        if (root==null) return null;

        if(root == t1 || root ==t2) return root;

        TreeNode left = lowestCommonAncestor(root.left,t1,t2);
        TreeNode right = lowestCommonAncestor(root.right,t1,t2);

        if(left!=null && right!=null) return root; //both side give element mean current root is parent
        else if(left==null && right==null) return null;  //both side give null mean both element not present in tree
        else if (left==null) return right;          //left give null mean whatver comes from right is the lca
        else if (right==null) return left;         //right is null mean whatever comes from left is the lca
        else return null; //it is never called but just to handle java compilation


    }

    static double maxAgv=Integer.MIN_VALUE;
    static TreeNode maxRoot = null;
    public double getMaxAvg(TreeNode root){
        recursiveFindChildSum(root);
        return maxAgv;
    }
    public int[] recursiveFindChildSum(TreeNode root){
        if (root==null) return new int[]{0,0};

        int[] left = recursiveFindChildSum(root.left);
        int[] right = recursiveFindChildSum(root.right);


        int[] res = new int[]{0,0};
        res[0] = left[0]+right[0]+root.val;
        res[1] = left[1]+right[1]+1;
        double curr = 1.0*res[0]/res[1];
        if(curr > maxAgv){
            maxAgv=curr;
            maxRoot=root;
        }
        return res;
    }
    public List<List<Integer>> verticalTravel(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        return res;
    }

}
