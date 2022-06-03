public class LT4_MedianTwoSortedArrays {

    public static void main(String[] args) {
        int[] a1 = {1,2};
        int[] a2 = {3,4};
        double r = findMedianSortedArrays(a1,a2);
        System.out.println(r);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median=0d;
        ///consider first array is small length and if not then do that first;
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        //first array is x and second array is y
        int lenX=nums1.length, lenY=nums2.length;
        int low=0, high=lenX;

        while (low<=high){
            //find 2 partition in both array
            int midX = (low+high)/2;
            int midY = (lenX+lenY+1)/2 - midX;

            //find 4 variable value in both array. LeftMax and RightMin in both array
            int leftMaxX = (midX==0) ? Integer.MIN_VALUE : nums1[midX-1];
            int rightMinX = (midX==lenX) ? Integer.MAX_VALUE : nums1[midX];

            int leftMaxY = midY==0 ? Integer.MIN_VALUE : nums2[midY-1];
            int rightMinY = midY==lenY ? Integer.MAX_VALUE : nums2[midY];

            if( leftMaxX <= rightMinY && leftMaxY<=rightMinX ){
                if( (lenX+lenY)%2 ==0){
                    int lmax = Math.max(leftMaxX,leftMaxY);
                    int rmin = Math.min(rightMinX,rightMinY);
                    median=1.0*(lmax+rmin)/2;
                }else {
                    median=Math.max(leftMaxX,leftMaxY);
                }
                break;
            }else if(leftMaxX> rightMinY){
                high=midX-1;
            }else {
                low=midX+1;
            }

        }

        return median;
    }
}
