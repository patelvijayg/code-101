public class LT543_DiameterBinaryTree {
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

    public int diameterOfBinaryTree(TreeNode root) {
        Pair pair = getDiameter(root);

        return pair.diameter;
    }
    public Pair getDiameter(TreeNode root){

        if(root == null){
            return new Pair(-1,0);
        }
        Pair left = getDiameter(root.left);
        Pair right = getDiameter(root.right);

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
