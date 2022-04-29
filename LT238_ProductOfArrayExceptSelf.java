import java.util.Arrays;

public class LT238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        LT238_ProductOfArrayExceptSelf driver = new LT238_ProductOfArrayExceptSelf();
        int[] nums={2,1,4,3};
        int[] result_expected={12,24,6,8};
        int[] result_actual = driver.productExceptSelf(nums);
        System.out.println(Arrays.toString(result_actual) + " == "+Arrays.toString(result_expected));
    }
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int[] result = new int[len];
        int[] leftprod = new int[len];
        int[] rightprod = new int[len];
        //First element of left array will be 1 and rest will be accumulated product
        leftprod[0]=1;
        for(int i=1;i<len;i++){
            leftprod[i]=nums[i-1]*leftprod[i-1];
        }
        //last element of right array will be 1 and rest will be accumulated product
        rightprod[len-1]=1;
        for(int i=len-2;i>=0;i--){
            rightprod[i]=nums[i+1]*rightprod[i+1];
        }
        // input array                                       2,  1,  4, 3
        //System.out.println(Arrays.toString(leftprod)); // [1,  2,  2, 8]
        //System.out.println(Arrays.toString(rightprod)); //[12, 12, 3, 1]

        for (int i=0;i<len;i++){
            result[i]=leftprod[i]*rightprod[i];
        }
        return result;
    }
}
