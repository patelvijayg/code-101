public class LT11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        LT11_ContainerWithMostWater driver = new LT11_ContainerWithMostWater();
        int area=driver.maxArea(height);
        System.out.println(area);
    }

    public int maxArea(int[] height) {
        int leftIndex=0;
        int rightIndex=height.length-1;
        int max=0;

        while(leftIndex<rightIndex){
            //calculate area
            int lengthBetweenPole=rightIndex-leftIndex;
            int minHeight=Math.min(height[leftIndex],height[rightIndex]);
            int area = lengthBetweenPole * minHeight;
            //chcek if current area beats max area
            if(area>max) max=area;
            //now shift the pointer from whichever is smaller
            if(height[leftIndex]<height[rightIndex])
                leftIndex++;
            else
                rightIndex--;
        }
        return max;
    }
}
