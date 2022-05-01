public class LT152_MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        LT152_MaximumProductSubarray driver = new LT152_MaximumProductSubarray();
        int result=driver.maxProduct(nums);
        System.out.println(result);
    }
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        //Make sure we initials with this to cover single element and zero case.
        int max=Integer.MIN_VALUE;

        int curr=1;
        //answer will alwasys include either first or last element (incase of zero value
        //we will discard that part and new first or last wil be used.
        // we will make 2 passes(left to right and right to left)
        for(int i=0; i<nums.length;i++){
            curr=curr*nums[i];
            if(curr>max) max=curr;
            //If we found 0 in between then we will reset the curr=1
            if(curr==0){
                curr=1;
            }
        }
        //We must reset this variable for right pass.
        curr=1;
        for(int i=nums.length-1;i>=0;i--){
            curr=curr*nums[i];
            if(curr>max) max=curr;
            //If we found 0 in between then we will reset the curr=1
            if(curr==0){
                curr=1;
            }
        }
        return max;
    }
}
