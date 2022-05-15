import java.util.Arrays;

public class Template_String {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int left=0,right=s2.length()-1;
        while (left<=right){
            if(s1.charAt(left)!=s2.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public static boolean isAnagram(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1,c2);
    }
}
