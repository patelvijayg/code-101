import java.util.Arrays;

public class LT204_CountPrimes {
    //Logic is first make all primes and then
    //start outer loop from 2 to sqrt(N)
    //inner loop only runs if that number is prime and set all the non prime numbers to false
    // in short any prime number multiplication is non prime..
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int count=0;

        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr,true);

        for(int i=2; i*i<=n; i++){
            if(arr[i]==true){
                int start = i*i;
                int step= i;
                for(int j=start; j<=n; j+=step){
                    arr[j]=false;
                }

            }

        }

        for(int i=2;i<n;i++){
            if(arr[i]==true) count++;
        }

        return count;
    }
}
