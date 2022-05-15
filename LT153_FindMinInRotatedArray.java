public class LT153_FindMinInRotatedArray    {
    public static void main(String[] args) {
        int[] nums={4,5,6,-1,0,1,2};
        LT153_FindMinInRotatedArray driver = new LT153_FindMinInRotatedArray();
        int min=driver.findMin(nums);
        System.out.println(min);
    }
    public int findMin(int[] nums) {

        if(nums.length == 1 ) return nums[0];
        int low=0, high=nums.length-1;
        //If start element is smaller than last emement
        //it means array has not rotated
        if(nums[low] < nums[high]) return nums[0];

        //
        while(low <= high){
            int mid = low + (high-low)/2;
            int curr = nums[mid];
            //Check the left and right side of mid and if mismatch then return directly.
            //if mid element greater then mid+1 then break is here because it start decrease from here
            if(curr > nums[mid+1] ){
                return nums[mid+1];
                ///If mid is smaller then mid-1 means break is here
            }else if( curr < nums[mid-1]){
                return nums[mid];
                //If first element is smaller then mid one then this part is sorted.
                //Now we can move low to mid
            }else if( nums[low] < nums[mid] ){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return -1;

    }
}
