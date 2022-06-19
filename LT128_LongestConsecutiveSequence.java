import java.util.*;

public class LT128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        //By default any number is consecutive seq so we can set default
        int ans=1;
        //put it into set so searching would be fast O(1)
        Set<Integer> set = new HashSet();
        for(int i=0; i<nums.length;i++){
            set.add(nums[i]);
        }
        //loop through all element and check the seq
        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            int len=0;
            //if element-1 is exist mean it is part of sequence but we are
            //looking for start of sequence so it must not be present in seq
            if(set.contains(curr-1)==false){
                //since it part of seqence we can start looking next value
                while(set.contains(curr)){
                    len++;
                    curr++;
                }
            }
            //check if any greater seq found then previous one
            ans=Math.max(ans,len);
        }

        return ans;
    }
}
