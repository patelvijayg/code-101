import java.util.*;

public class TemplateDisJointSet {
    public static void main(String[] args) {
        DisJointSet d = new DisJointSet(6);
        d.union(0,1);
        d.union(0,2);
        d.union(2,3);
        d.union(4,5);
        System.out.println(d.isGroup(0,4));
    }
    private static class DisJointSet{
        private int[] parent = null;
        private int[] rank = null;

        public DisJointSet(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i <n ; i++) {
                parent[i]=i;
                rank[i]=0;
            }
        }
        public boolean isGroup(int x, int y){
            int xroot = findParent(x);
            int yroot = findParent(y);
            return xroot==yroot;
        }
        public int findParent(int x){
            if(parent[x] != x){
                parent[x]=findParent(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y){
            int xroot = findParent(x);
            int yroot = findParent(y);

            if(xroot==yroot) return;
            //update parent of smaller rank because it can join that group under less rank.
            if(rank[xroot]<rank[yroot]){
                parent[xroot] = yroot;
            } else if (rank[yroot]<rank[xroot]) {
                parent[yroot]=xroot;
            }else {
                //both are same so make one as parent and increase that parent rank to +1 on.
                //here we consider xroot as parent so update it rank and also assign other node parent is xroot
                parent[yroot]= xroot;
                rank[xroot] =rank[xroot]+1;
            }

        }

    }



}
