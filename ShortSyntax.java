import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortSyntax {

    public static void main(String[] args) {

        ArrayList<Integer> a =new ArrayList<>();
        a.remove(0);
        direction4Move();
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
    private static int[] newIntArray(){
        Queue<int[]> queue= new PriorityQueue<>((a,b)->a[0]-b[0]);

        return new int[]{1, 2, 4};
    }
}
