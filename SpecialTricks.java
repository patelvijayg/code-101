import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpecialTricks {
    public static void main(String[] args) {
        //int[] arr=new int[]{2, 1, 3, 5, 3, 2};
        //int r3 = firstDuplicate2(arr);
        //System.out.println(r3);
        int[] arr=new int[]{1,2,3,4,5,6};
        rotateArrayKElement(arr,2);
        System.out.println(Arrays.toString(arr));
        
    }
    //time O(N) spce O(1)
    public static int firstDuplicate(int[] arr){
        //you are making position as duplicate value once it is appear
        for (int i = 0; i < arr.length; i++) {
            int newPosition=Math.abs(arr[i])-1;
            if(arr[newPosition]<0){
                return Math.abs(arr[i]);
            }else {
                arr[newPosition]=-arr[newPosition];
            }
        }
        return -1;
    }
    //time O(N) spce O(N)
    public static int firstDuplicate2(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.add(arr[i])==false){
                return arr[i];
            }
        }
        return -1;
    }
    public static char firstNonRepeatingChar(String s){
        //Optimal if first index and last index are same then we can return it.
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if( s.indexOf(c)==s.lastIndexOf(c) ){
                return c;
            }
        }
        int[] fre = new int[26];
        for (char c: s.toCharArray()){
            fre[c-'a']++;
        }
        for(char c: s.toCharArray()){
            if( fre[c-'a']==1 )return c;
        }
        return '-';
    }
    //you have to do it in place
    public static void rotateArrayKElement(int[] arr , int k){
        reverseArray(arr,0,arr.length-1);
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,arr.length-1);

    }
    public static void reverseArray(int[] arr, int i, int j){
        while (i<=j){
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
            i++;
            j--;
        }
    }
}
