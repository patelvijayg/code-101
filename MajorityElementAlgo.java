import java.util.*;
public class MajorityElementAlgo {
    public static void main(String[] args) {
        int[] nums = {2,3,2,1,4,2,4,2,3,2,3,2,2};
        int majority =findMajorityElement(nums);
        System.out.println(majority);
    }
    //using moore voting algorithm we can find the majority element
    public static int findMajorityElement(int[] arr){
        //declare candidate and count
        int candiate=0;
        int vote=0;

        for (int i = 0; i < arr.length; i++) {
            //if vote count is zero then we select candidate and vote it

            if(vote == 0){
                candiate=arr[i];
            }

            //Now let increase vote cound if same candidate comes
            if(candiate == arr[i]){
                vote++;
            }else {
                vote--;
            }

        }
        return candiate;
    }
    //majority of 2/3 with moore algo.
    public static ArrayList < Integer > majorityElement(int[] nums) {

        int candiate1 = -1, candidate2 = -1, vote1 = 0, vote2 = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == candiate1)
                vote1++;
            else if (nums[i] == candidate2)
                vote2++;
            else if (vote1 == 0) {
                candiate1 = nums[i];
                vote1 = 1;
            } else if (vote2 == 0) {
                candidate2 = nums[i];
                vote2 = 1;
            } else {
                vote1--;
                vote2--;
            }
        }
        //now we need to verify whether above both candidate really have 2/3 majority or less
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        vote1 = 0;
        vote2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == candiate1)
                vote1++;
            else if (nums[i] == candidate2)
                vote2++;
        }
        if (vote1 > len / 3)
            ans.add(candiate1);
        if (vote2 > len / 3)
            ans.add(candidate2);
        return ans;
    }
}
