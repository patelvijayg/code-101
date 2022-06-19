import java.util.*;

public class GFG_SmallestDistinctWindow {
    //Find Distinct Value in Smallest Window
    public int findSubString(String str) {
        int n = str.length(), left = 0, right = 0, ans = n, count = 0;

        //find total distinct element as we need to check all present in window or not
        Map<Character, Integer> map = new HashMap();
        for (char ch : str.toCharArray()) {
            addChar(ch, map);
        }
        //total distinct values present in string
        count = map.size();
        //clear map to reuse in further processing
        map.clear();

        while (right < n) {
            int len = n;
            //NOTE: We must first check this condition so after adding we can check window has enough number or not
            //First increase window til we found our matching count
            while (map.size() < count && right < n) {
                addChar(str.charAt(right), map);
                right++;
            }
            //now we need to shrink window till we make invalid condiation
            while (map.size() >= count) {
                len = right - left;
                //System.out.println("size="+map.size() + " len"+len);
                if (len < ans) ans = len;
                removeChar(str.charAt(left), map);
                left++;
            }

        }
        return ans;
    }

    public void addChar(char ch, Map<Character, Integer> map) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    public void removeChar(char ch, Map<Character, Integer> map) {
        if (map.containsKey(ch)) {
            int count = map.get(ch);
            if (count == 1) {
                map.remove(ch);
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
    }
}
