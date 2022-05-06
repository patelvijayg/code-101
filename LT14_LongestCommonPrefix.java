import java.util.Arrays;

public class LT14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        //We can sort the entire array and then compare first and last element and it will have longest common prefix
        Arrays.sort(strs);

        String first=strs[0];
        String last=strs[strs.length-1];
        //we only need to iterate smallest string.
        int minLen =Math.min(first.length(),last.length());
        int end=0;
        for(int i=0;i<minLen;i++){
            if(first.charAt(i)==last.charAt(i)) end++;
            else break;
        }
        return first.substring(0,end);
    }
}
