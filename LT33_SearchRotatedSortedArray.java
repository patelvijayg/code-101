public class LT33_SearchRotatedSortedArray {

    public int search(int[] arr, int target) {
        //there will be atleast one sub array which will be always sorted
        //and we need to find that and check result lies in between ?
        //if not than we will discard that portion and make same activity
        int left=0, right=arr.length-1, mid=0;

        while(left<=right){
            mid=left+(right-left)/2;
            //happy case
            if(arr[mid] == target){
                return mid;
             //mid is greater than left then it is case where first half is sorted.

            }else if( arr[mid] > arr[left] ){
                //now we can check if result is in between this portion.
                //if not then we will discard left part so left will be mid+1
                if(target<=arr[mid] && target>= arr[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }

            }else{
                //this is the case where second part of the array is sorted.
                //we will see result lies in between.
                //if not then we will discard this section by setting righ=mid-1
                if(target<=arr[mid] && target>= arr[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }


        }
        return -1;
    }
}
