import java.util.Arrays;

public class BitsSample {
    ///-x = ~x + 1;   (it is two’s 2’s complement formula)
    public static void main(String[] args) {
        Integer num=24;

        System.out.println(Integer.toBinaryString(num));
        System.out.println(findNthBits(num,1));
        System.out.println( 15>>1);
        int[] input = {1,2,1,3,2,5};
        int[] res =singleNumber(input);
        System.out.println(Arrays.toString(res));
        xorfirstNnumer(40);
        System.out.println(findLastSetBitPosition(20));
    }
    public static int findNthBits(int number, int bit){
        int mask = (1<<bit);
        int result = (number & mask);
        return result;
    }

    public static int removeLastSetBit(int n){
        return n & (n-1);
    }
    public static int findLastSetBitPosition(int n){
        int val= n & (-n);
        int pos = log(val,2);
        return pos+1;
    }
    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }
    public  static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int diff = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            diff = diff ^ nums[i];
        }
        int lastbit = diff & (-diff);  //get the right most set bit using this formulla
        int group1=0, group2=0;

        for (int i = 0; i < len; i++) {
            //now we are comparing each number and make it two buckets. matching bit are in one bucket and remaining in another
            //while putting in bucket we can doing xor so we dont need to to loop again.
            boolean match= (nums[i] & lastbit)>0;
            if(match==true){
                group1 = group1 ^ nums[i];
            }else{
                group2=group2 ^ nums[i];
            }
        }
        res[0]=group1;
        res[1]=group2;
        return res;
    }

    public static int xorfirstNnumer(int n){
        //there are only 4 possible answer of n element xor..
        int rem=n % 4;
        if( rem ==0) {
            return n;
        }else if(rem == 1){
            return 1;
        }else if (rem == 2){
            return n+1;
        }else {
            //this is the case when rem == 3
            return 0;
        }
    }

}
