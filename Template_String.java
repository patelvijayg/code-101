import java.util.Arrays;

public class Template_String {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome1(String s1){
        StringBuilder sb1 =new StringBuilder(s1);
        return sb1.reverse().toString().equals(s1);
    }
    public static boolean isPalindrome2(String s1, String s2){
        StringBuilder sb1 =new StringBuilder(s1);
        return sb1.reverse().toString().equals(s2);
    }

    public static boolean isPalindrome_2(String s1, String s2){
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
    public static void freqCount(String s1){
        int[] fre = new int[26];
        for(char c : s1.toCharArray()){
            fre[c-'a']++;
        }

        char[] arrchar = new char[fre.length];
        for (int i=0; i<fre.length;i++){
            arrchar[i]= (char) (fre[i]+'a');
        }
    }
}
