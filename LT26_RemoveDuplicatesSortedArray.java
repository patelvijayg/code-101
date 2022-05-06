public class LT26_RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        int left=1, right=1 , len=nums.length;
        if(len == 1) return 1;

        while(right < len ){
            if(nums[right-1] == nums[right]){
                right++;
            }else{
                nums[left]=nums[right];
                left++;
                right++;
            }

        }
        return left;

    }
}
