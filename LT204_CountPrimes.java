import java.util.Arrays;

public class LT204_CountPrimes {
    public static void main(String[] args) {
        LT204_CountPrimes driver = new LT204_CountPrimes();
        int primes = driver.countPrimes(20);
    }

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
                //make all the muitplier of this number as non-prime because
                //eg. 2 is prime then 2*2=false, 2*2+2, 2*2+4, 2*2+6 will not be prime
                //eg. 3 is prime then 3*3=false, 3*3+3, 3*3+6, 3*3+9 will not be prime
                int start = i*i;
                while (start<=n){
                    arr[start]=false;
                    start=start+i;
                }
            }

        }

        for(int i=2;i<n;i++){
            if(arr[i]==true) {
                //System.out.println(i);
                count++;
            }
        }

        return count;
    }
}
