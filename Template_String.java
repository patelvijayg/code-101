import java.util.*;
import java.util.stream.Collectors;

public class Template_String {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        Template_String driver = new Template_String();
        String res=driver.findLCSRecursive(s1,s2);
        System.out.println(res);

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
    /// longest palindromic subsequence
    /// how many min modification require to make superstring of two string
    /// how many min modification require to make one string to another string

    public String findLCSRecursive(String s1, String s2){

        return _findLcsRec(0,0,s1,s2);
    }
    private String _findLcsRec(int i, int j,   String s1,String s2){
        if(i == s1.length() || j==s2.length()) return "";
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        List<Character> res=new ArrayList<>();
        if(c1==c2) {
            return ""+ c1 + _findLcsRec(i+1,j+1,s1,s2);
        }else {
            String r1 =  _findLcsRec(i+1,j,s1,s2);
            String r2 =  _findLcsRec(i,j+1,s1,s2);
            if(r1.length()>r2.length()) {
                return r1;
            }else {
                return r2;
            }
        }
    }
}
