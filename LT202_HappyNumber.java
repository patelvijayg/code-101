import java.util.*;
public class LT202_HappyNumber {
    Set<Integer> set = new HashSet();
    public boolean isHappy(int n) {
        //if it found in set it mean it is creating cycle so it will never reach to 1
        if(set.contains(n)) return false;
        int tmp=n;
        int next=0;
        while(tmp>0){
            Integer i = tmp % 10;
            tmp = tmp / 10;
            next = next + (i*i);
        }
        //all numer 1 and 7 are happy number
        if(next == 1 || next ==7) return true;
        set.add(n);
        return isHappy(next);
    }
}
