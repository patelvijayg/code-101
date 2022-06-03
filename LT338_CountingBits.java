import java.util.Arrays;

public class LT338_CountingBits {

    public static void main(String[] args) {
        int n=9;
        LT338_CountingBits driver = new LT338_CountingBits();
        int[] result = driver.countBits(n);
        System.out.println(Arrays.toString(result));
    }

    public int[] countBits(int n) {
        //No of bit of even number is the same as number by 2
        // (eg.  6/2 = 3 mean bits of 1 in 6 and 3 are same(2) and 20/2 , 10 so 20 and 10 has same bits
        //if Number is odd then it has one more bit + number divide by 2 bit count.
        //eg. 5/2 = 2 so bit count of x/2+1
        //intution is when we right shift the 1 bit is remove last bit and incase of odd it must be 1 and for even it is 0
        //and when it shift number is actually x/2.

        int[] bits = new int[n+1];
        bits[0]=0;

        for (int i = 1; i <=n ; i++) {
            int half=i/2;
            boolean isEven=i%2==0;
            if(isEven){
                bits[i]=bits[half];
            }else {
                bits[i]=bits[half]+1;
            }

        }
        return bits;
    }

// N | Bit  | count | offset  | value
// 0 | 0000 | 0     | 0       | 0
// 1 | 0001 | 1     | 1       | 1 + dp[1-1] = 1 + dp[0] = 1 + 0 = 1
// 2 | 0010 | 1     | 2       | 1 + dp[2-2]
// 3 | 0011 | 2     | 2       | 1 + dp[3-2]
// 4 | 0100 | 1     | 4       | 1 + dp[4-4]
// 5 | 0101 | 2     | 4       | 1 + dp[5-4] = 1 + dp[1] = 1+ 1 = 2
// 6 | 0110 | 2     | 4       | 1 + dp[6-4]
// 7 | 0111 | 3     | 4       | 1 + dp[7-4] = 1 + dp[3] = 1 + 2 = 3
// 8 | 1000 | 1     | 8       | 1 + dp[8-8]

// now we can derive formula for calculating offset by increasing one if it is power of 2
// so final formula looks
// dp[n] = 1 + dp[n - offset] where offset represent value of MSB bit (2^msb = 1,2,4,8,16..)


    public int[] countBits1(int n) {
        int[] dp = new int[n+1];
        //Base case
        dp[0] = 0;
        //start of offset as 1 and increaes when it reaches power of 2 value
        int offset=1;

        for(int i=1; i<=n; i++){
            //We need to increase offset if it is power of 2
            if ( (offset * 2) == i ) {
                offset = i;
            }
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }


}
