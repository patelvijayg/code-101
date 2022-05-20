public class Template_KadanesAlgo {
    public static void main(String[] args) {
        Template_KadanesAlgo driver = new Template_KadanesAlgo();

        int[] input= {1,2,3,4,1,2,-13,3,4,5,6,4,2};
        long r1=driver.maxSubarraySum(input,input.length);
        System.out.println(r1);

    }
    //kadane algorithm
    public long maxSubarraySum(int arr[], int n){
        long cursum=arr[0];
        long maxsum=arr[0];
        for(int i=1; i<arr.length; i++){
            //cursum=Math.max(arr[i], arr[i]+cursum);
            //above syntax can be simply in fillowing code.
            //here current sum can be nagative hence if we add into curr element then
            //it may produce smaller value
            if( arr[i] > (arr[i]+cursum) ){
                cursum=arr[i];
            }else {
                cursum=arr[i]+cursum;
            }
            maxsum=Math.max(maxsum, cursum);
        }
        return maxsum;
    }
}
