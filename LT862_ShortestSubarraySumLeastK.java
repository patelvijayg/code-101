import java.util.ArrayDeque;

public class LT862_ShortestSubarraySumLeastK {
    public static void main(String[] args) {
        int[] arr= new int[]{2,7,3,-8,4,10}; //12 -> 2
        //int[] arr= new int[]{-28,81,-20,28,-29}; //81 - 3
        //int[] arr= new int[]{-11,-15,76,41,-41,68,41,12,73,-8}; //50 - 3
        arr= new int[]{48,99,37,4,-31}; //140 = 2
         int r= shortestSubarray(arr,140);
        System.out.println(r);
    }
    //this approach uses prefix sum to reduce complexity
    public static int shortestSubarray(int[] nums, int k) {
        int INDEX=1, SUM=0;
        int  min=Integer.MAX_VALUE;
        //make sure you take sum variable as long type becaues value are too large
        ArrayDeque<long[]> dq = new ArrayDeque<>();
        long[] presum= new long[nums.length];
        //prepare the prefix sum
        for (int i = 0; i <nums.length ; i++) {
            presum[i]= nums[i] + ( i==0 ? 0 : presum[i-1]);
        }

        for (int i = 0; i < presum.length; i++) {
            long currSum = presum[i];
            //if current sum is greater mean first match happens.. lets add its length.
            //it must be index+1 becaues index start with 0.
            if(currSum>=k){
                min=Math.min(min,i+1);
            }
            //Lets check the first scenario where take difference between current sum
            // and first element to shrink the queue. if it matches and we will remove
            //item till it became less then k and store the last removed item
            //because that it was valid so we can find another length of min.
            long[] firstRemovedItem = new long[]{-1,-1};
            while (dq.size()>0 && currSum - dq.peekFirst()[SUM] >= k){
                firstRemovedItem= dq.removeFirst();
            }
            //this will be incase any item removed and queue was shrinked.
            if(firstRemovedItem[INDEX] != -1){
                min= (int) Math.min(min, i-firstRemovedItem[INDEX] );
            }
            //before pushing the current item we need to check that we can only put item in
            //greater item order.. we need to remove if any greater item then current.
            while(dq.size()>0 && dq.peekLast()[SUM] > currSum){
                dq.removeLast();
            }
            //add the current element anyway.
            dq.addLast(new long[]{currSum,i});
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
       public static int shortestSubarray2(int[] nums, int k) {
           int INDEX=1, SUM=0;
           int right=0,len=nums.length, min=Integer.MAX_VALUE;
           //make sure you take sum variable as long type becaues value are too large
           long sum=0;
           ArrayDeque<long[]> dq = new ArrayDeque<>();
           while (right<len){
            ///it is running sum prefix kind of sum
            sum=sum+nums[right];
            if(sum>=k){
                min=Math.min(min,right+1);
            }
            boolean itemRemvoed=false;
            long[] lastitem=new long[2];
            //remove from the first if we got solution to shrink array and keep lastitem
            //for handy to find the removed last item from queue.
            while(dq.size()>0 && sum-dq.peekFirst()[SUM] >=k){
                itemRemvoed=true;
                lastitem= dq.removeFirst();
            }
            ///if we have removed the item then we must found one solution so lets
            /// update our min variable with current pointer - removed item pointer
            /// because after removed the item our sum is not greater.
            if(itemRemvoed){
                min= (int) Math.min(min, right-lastitem[INDEX] );
            }
            ///Incase you found element smaller than last top element then
            ///we need to remove all such element till our sum is bigger than that
            while (dq.size()>0 && dq.peekLast()[SUM]>=sum){
                dq.removeLast();
            }
            //add this current element anyway
            dq.addLast(new long[]{sum,right});
            right++;
        }

        return min==Integer.MAX_VALUE?-1:min;
    }



}
