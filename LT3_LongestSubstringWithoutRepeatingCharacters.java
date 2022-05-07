import java.util.*;
public class LT3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //two pointer with sliding window technique
        int left=0, right=0, max=0;
        Set<Character> set = new HashSet();
        while(right<s.length()){
            char curr =s.charAt(right);
            if(!set.contains(curr)){
                set.add(curr);
                max=Math.max(max, right-left+1);
                right++;
            }else{
                char prev=s.charAt(left);
                set.remove(prev);
                left++;
            }

        }
        return max;
    }
}
