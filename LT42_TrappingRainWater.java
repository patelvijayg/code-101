import java.util.Arrays;

public class LT42_TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        LT42_TrappingRainWater driver=new LT42_TrappingRainWater();
        int water = driver.trap(heights);
        System.out.println(" result="+water);
    }
    public int trap(int[] height) {
        int n=height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //find the largest left element
        left[0]=height[0];
        for (int i = 1; i < n; i++) {
            left[i]=Math.max(left[i-1],height[i]);
        }
        //find the largest element in right
        right[n-1]=height[n-1];
        for (int i = n-2; i>=0; i--) {
            right[i]=Math.max(height[i],right[i+1]);
        }
        int sum=0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            //since water can fill till smallest of both end (left, right)
            //so we will take smallest amonst that and we need to
            //substract the height of current bar
            int singleWater = Math.min(right[i],left[i])-height[i];
            sum=sum+singleWater;
            System.out.print(" "+singleWater+",");
        }

        return sum;
    }
}
