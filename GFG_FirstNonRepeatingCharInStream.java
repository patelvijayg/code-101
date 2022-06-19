import sun.awt.image.OffScreenImageSource;

import java.util.*;

public class GFG_FirstNonRepeatingCharInStream {
    public static void main(String[] args) {
        String repeat = "hbbchtlcuaorghfd";
        String expected="hhhhcccttttttttt";
        String ans = FirstNonRepeating(repeat);
        System.out.println(repeat);
        System.out.println(ans);
        System.out.println(expected);
    }
    public static String FirstNonRepeating(String A)
    {
        int n=A.length();
        char[] ans = new char[n];
        int[] cnt = new int[26];
        Queue<Character> queue = new LinkedList<>();
        int i=0;
        while (i<n){
            char curr = A.charAt(i);
            queue.add(curr);
            int index=curr-'a';
            cnt[index]++;
            char first='#';
            while (queue.size()>0 && cnt[queue.peek()-'a']>1 ){
                queue.remove();
            }
            if(queue.size()>0) {
                first=queue.peek();
            }
            ans[i]=first;
            i++;
        }

        return new String(ans);
    }
}
