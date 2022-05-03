import java.util.*;

public class LT139_WordBreak {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        LT139_WordBreak driver = new LT139_WordBreak();
        boolean result = driver.wordBreak(s, wordDict);
        System.out.println("possible="+result);
    }

    Map<String,Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        //chcek if entire string is part of wordDict
        if(wordDict.contains(s)) return true;
        //check if result present in cache
        if(map.containsKey(s)) return map.get(s);
        //start breaking string into parts
        for (int i = 0; i < s.length(); i++) {
            String leftPart=s.substring(0,i);
            String rightPart=s.substring(i);
            //check first part present and then only make call rest part recursively
            if(wordDict.contains(leftPart) && wordBreak(rightPart,wordDict)){
                map.put(s,true);
                return true;
            }
        }

        map.put(s,false);
        return false;
    }
}
