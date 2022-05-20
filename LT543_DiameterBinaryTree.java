public class LT543_DiameterBinaryTree {
    //solution 1. keep variable global and compare each nodes as root (of left edges + right edges + 1)
    // here each node get chance to act as root and update diameter variable
    //main crux of program is return -1 if root is null and make diameter variable global.
    int dia =0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return dia ;
    }
    public int dfs(TreeNode root){
        if(root == null) return -1; //since we return edges we need to return -1 to make cacluation easy.

        int left = dfs(root.left);
        int right = dfs(root.right);
        ///this is the case when it passes through root
        dia = Math.max(dia, left+right+2); //adding 2 because it will be add 2 edges to connect their childrens
        /// this is the case when we consider stright path and include current node path
        return 1 + Math.max(left,right);

    }

    ///solution 2 : here pair will be return will straigh path, subtree node count..
    public int diameterOfBinaryTree2(TreeNode root){
        int[] result = countOfMaxNodePath(root);
        //since result gives the count of nodes we will substract -1 to get edges
        return Math.max( result[0],result[1] )-1;
    }
    ///it return straith path, subtreepath
    public int[] countOfMaxNodePath(TreeNode root){
        if(root == null){
            return new int[]{0, 0};
        }
        int[] left = countOfMaxNodePath(root.left);
        int[] right = countOfMaxNodePath(root.right);

        //case one
        int subtreeMax = Math.max(left[1],right[1]); //incase any subtree is having long path
        int includeRoot = left[0]+right[0]+1; //left straight path + right Straight path +1;
        int finalsubtree = Math.max(subtreeMax,includeRoot);
        int currentStraigthPath= Math.max(left[0],right[0])+1; // this straigth path send to parent to consider
        int[] result = new int[]{currentStraigthPath,finalsubtree};
        return result;

    }

    //Solution 3
    public int diameterOfBinaryTree1(TreeNode root) {
        Pair pair = getDiameter1(root);

        return pair.diameter;
    }
    //We will keep one pair class to caclulate diameter and height of
    static class Pair{
        int height;
        int diameter;
        public Pair(){}
        public Pair(int h, int d){
            this.height=h;
            this.diameter=d;
        }

    }
    public Pair getDiameter1(TreeNode root){

        if(root == null){
            return new Pair(-1,0);
        }
        Pair left = getDiameter1(root.left);
        Pair right = getDiameter1(root.right);

        Pair maxPair=new Pair();
        //Find the max heigth from left and right and add 1 for self height
        maxPair.height = Math.max(left.height, right.height) + 1;

        //If we include the root then we will add 2 edges to connect both node.
        int includeRoot = left.height + right.height + 2;

        //There may be chances that root is not included as one of side got max diameter
        int foudOnlyOneSide = Math.max(left.diameter, right.diameter);

        //final diameter will be race between oneside and incldue root
        maxPair.diameter = Math.max(includeRoot,foudOnlyOneSide);

        return maxPair;

    }

}
