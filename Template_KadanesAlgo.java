import java.util.*;

public class Template_KadanesAlgo {
    public static void main(String[] args) {
        Template_KadanesAlgo driver = new Template_KadanesAlgo();

        int[] input= {1,2,3,4,1,2,-50,3,4,5,6,4,2};
        long r1=driver.maxSubarraySum(input,input.length);
        System.out.println(r1);
        int[] input2= {1,2,3,4,-10,0,4,2,-6,1};
        int maxlen=driver.longestSubArraySumZero(input2,4);
        System.out.println(maxlen);
    }
    //kadane algorithm
    public long maxSubarraySum(int arr[], int n){
        long cursum=arr[0];
        long maxsum=arr[0];
        int mxstart=0, start=0, end=0;
        for(int i=1; i<arr.length; i++){
            //cursum=Math.max(arr[i], arr[i]+cursum);
            //above syntax can be simply in fillowing code.
            //here current sum can be nagative hence if we add into curr element then
            //it may produce smaller value
            if( arr[i] > (arr[i]+cursum) ){
                ///it is just consider as reset cursum to current element
                cursum=arr[i];
                start=i;
            }else {
                cursum=arr[i]+cursum;
            }
            if(cursum> maxsum){
                maxsum=cursum;
                end=i;
                mxstart=start;
            }
            //maxsum=Math.max(maxsum, cursum);
        }
        System.out.println("Start="+mxstart + "  end="+ end);
        return maxsum;
    }


    public int longestSubArraySumZero(int arr[], int target) {
        //int target = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //set 0 sum at index -1  this is to handle index-map.get(sum)
        map.put(0, -1);
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            //chcek if sum already exists then do not update index becaues we want largest subarray
            // you will ommit following condition if you want smallest array size.
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            int complement = -1 * (target - sum);

            //find the complement of the sum into map and then calculate length
            if (map.containsKey(complement)) {
                int firstIndex = map.get(complement);
                int currLen = i - firstIndex;
                if (currLen > maxLen) {
                    maxLen = currLen;
                }
            }


        }
        return maxLen;
    }
}
