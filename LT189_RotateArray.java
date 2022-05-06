public class LT189_RotateArray {
    //If we want to make it in O(1) space and O(n) time then only this is the solution.
    // we split array into 2 part 0 to k-1 and k to n
    // we will reverse this two subarray and finally reverse whole array.

    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k = k%len;
        if( k == 0 || len==1) return;

        int part1_start =0, part1_end=len-k-1;
        int part2_start =len-k, part2_end=len-1;
        int part3_start =0, part3_end=len-1;

        reverse(nums,part1_start,part1_end);
        reverse(nums,part2_start,part2_end);
        reverse(nums,part3_start,part3_end);



    }

    public void reverse(int[] nums, int start, int end){
        if(start == end) return;

        while(start<end){
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }

    }

}
