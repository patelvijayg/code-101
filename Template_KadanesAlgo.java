public class Template_KadanesAlgo {
    public long maxSubarraySum(int arr[], int n){
        long cursum=arr[0];
        long maxsum=arr[0];
        for(int i=1; i<arr.length; i++){
            cursum=Math.max(arr[i], arr[i]+cursum);
            maxsum=Math.max(maxsum, cursum);
        }
        return maxsum;
    }
}
