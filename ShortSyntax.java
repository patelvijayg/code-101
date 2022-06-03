import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class ShortSyntax {

    public static void main(String[] args) {

       // zigzag(5);
    }
    private static void frequecyChar(String s){
        int[] arr = new int[26];
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }
    }
    private static void direction4Move(){
        int x=1;
        int y=2;
        System.out.println("Original x="+x + " y="+y);
        int[] direction = new int[]{0,1,0,-1,0};
        for (int i = 0; i < direction.length-1 ; i++) {
            int newX = x + direction[i];
            int newY = y + direction[i+1];
            System.out.println("x="+newX+ " y="+newY);
        }
    }
    private static void direction4MoveSimple(){
        int x=1;
        int y=2;
        System.out.println("Original x="+x + " y="+y);
        //8 direction
        int[][] direction8 = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        //grid
        int[][] grid = new int[1][1];
        int m=grid.length,n=grid[0].length;
        //4 direction
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : directions){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX<0 || newX>=m || newY<0 || newY>=n || grid[newX][newY] != 1){
                continue;
            }
            System.out.println("x="+newX+ " y="+newY);

        }
    }
    private static int[] newIntArray(){
        Queue<int[]> queue= new PriorityQueue<>((a,b)->a[0]-b[0]);
        return new int[]{1, 2, 4};
    }
    public static void copyArrayByShiftFirstPostion(String s, String p){
        char[] arrStr = new char[s.length() + 1];
        char[] arrPtr = new char[p.length() + 1];
        System.arraycopy(s.toCharArray(), 0, arrStr, 1, s.length());
        System.arraycopy(p.toCharArray(), 0, arrPtr, 1, p.length());
    }
    public static void left_righ_largest(int[] heights){
        //find the left largest and right largest values
        int n=heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //find the largest left element
        left[0]=heights[0];
        for (int i = 1; i < n; i++) {
            left[i]=Math.max(left[i-1],heights[i]);
        }
        //find the largest element in right
        right[n-1]=heights[n-1];
        for (int i = n-2; i>=0; i--) {
            right[i]=Math.max(heights[i],right[i+1]);
        }
    }
    public static void left_right_next_larger(int[] heights){
        //this will stores the index position and not the actual value..
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> st = new Stack<>();
        //Find the left side smaller element
        for (int i = 0; i < n; i++) {
            //remove the items if you found bigger than or equals to current.
            //we have to use equal becaues same element will have same index if we remove
            //otherwise it will not give correct result.
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                left[i] = 0;
            }else {
                left[i]=st.peek()+1;
            }
            st.push(i);
        }
        st.clear();
        for (int i =n-1; i>=0; i--) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                right[i] = n-1;
            }else {
                right[i]=st.peek()-1;
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(right));
    }
    public static void zigzag(int numRange){
        //[0, 1, 2, 3, 4, 3, 2, 1]
        int[] dir = new int[numRange*2-2];
        for (int i = 0; i <numRange ; i++) {
            dir[i]=i;
        }
        for (int i = numRange; i<dir.length ; i++) {
            dir[i]=dir[i-1]-1;
        }
        System.out.println(Arrays.toString(dir));
    }
}
