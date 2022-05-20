import java.util.ArrayList;
import java.util.Arrays;

public class LT6_ZigzagConversion {
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        String output=convert(input,5);
        System.out.println(output +" === "+"PAHNAPLSIIGYIR");
    }
    public static String convert(String s, int numRows) {

        if(numRows==1) return s;
        ArrayList<Character>[] result = new ArrayList[numRows];
        for (int i = 0; i < result.length; i++) {
            result[i]=new ArrayList<>();
        }
        char[] arr = s.toCharArray();
        int[] dir = new int[numRows*2-2];
        for (int i = 0; i <numRows ; i++) {
            dir[i]=i;
        }
        for (int i = numRows; i<dir.length ; i++) {
            dir[i]=dir[i-1]-1;
        }

        for (int i = 0; i < arr.length; i++) {
            int arnum = dir[i % dir.length];
            result[arnum].add(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Character> item : result){
            for(Character c: item){
                sb.append(c);
            }
        }
        //System.out.println(Arrays.toString( dir));
        return  sb.toString();
    }
}
