import java.util.HashMap;
import java.util.Map;

public class LT01_TwoSum {
    public static void main(String[] args) {
       int[] nums = {2,7,11,15};
       int target = 9;
       int[] result_expected = {0,1};
       int[] result_actual=new int[2];
       LT01_TwoSum driver = new LT01_TwoSum();
       result_actual = driver.twoSum(nums,target);
       for(int i=0; i<result_actual.length;i++){
           System.out.println(""+result_actual[i]+"=="+result_expected[i]);
       }

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> itemKeyMap = new HashMap<>();
        //We will keep item as key and index as value of map
        for (int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            //check if diff is present in map. if yes the we found item
            if(itemKeyMap.containsKey(diff)){
                result= new int[]{itemKeyMap.get(diff), i};
                break;
            }
            //we will store all the visited element in map
            itemKeyMap.put(nums[i],i);
        }

        return result;
    }
}
