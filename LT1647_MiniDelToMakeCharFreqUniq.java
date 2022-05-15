import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LT1647_MiniDelToMakeCharFreqUniq {

    public static int minDeletions(String s) {
        //frequency array of char
        int result=0;
        int[] arr = new int[26];
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }
        //Keep set for track of added element
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int count = arr[i];
            //check if same number added
            if (count>0 && !set.contains(count)) {
                set.add(count);
            } else {
                //try to decrement number and check if you can add into set
                for (int j = count - 1; j >=0; j--) {
                    result++;
                    if (!set.contains(j)) {
                        set.add(j);
                        break;
                    }

                }
            }
        }
        return result;
    }

    public int minDeletions1(String s) {
        //frequency array of char
        int result=0;
        int[] arr = new int[26];
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            arr[c-'a']++;
        }

        Arrays.sort(arr);
        //Make it last frequecy
        int last = s.length();
        //loop should be run only for arr[i]>0
        for(int i=25; i>=0 && arr[i]>0; i--){
            //if current frequrecy greater than last then we need to reduce it to last
            //and add the deleteion as difference
            int curr = arr[i];
            if( curr > last){
                result=result + (curr-last);
                arr[i]=last;
            }
            //last frequecy should be not be negative and also we need to
            //reduce 1 for further processing
            last = Math.max(0, curr-1);
        }


        return result;
    }
}
