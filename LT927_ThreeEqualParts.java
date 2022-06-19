import java.util.Arrays;

public class LT927_ThreeEqualParts {
    public static void main(String[] args) {
        LT927_ThreeEqualParts driver = new LT927_ThreeEqualParts();
        int[] arr={1,0,1,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,1,0};
        int[] res = driver.threeEqualParts(arr);
        System.out.println(Arrays.toString(res));
    }
    public int[] threeEqualParts(int[] arr) {
        int count=0, n=arr.length;
        int[] invalid = new int[]{-1,-1};

        //first count number of ones and check it is in pair of 3
        for(int i=0;i<n;i++){
            if(arr[i]==1) count++;
        }
        //if count is not divdie by 3 means it is invalid
        if(count%3!=0) return invalid;
        //if no of one are zero then return default
        if(count==0) return new int[]{0,n-1};
        //find how many once should be in each partition
        int ones = count/3;

        //find the each partition start and end point
        int i1=0,i2=0,i3=0,j1=0,j2=0,j3=0;
        count=0;
        for(int i=0; i<n; i++){
            if(arr[i]==1){
                count++;
                //any partition start point is N*ones+1 (where N=0...partition-1 here it is 0..3)
                if(count== 0*ones+1) i1=i;
                if(count==1*ones+1) i2=i;
                if(count==2*ones+1) i3=i;
                //any partition end point is N*ones (where N=1...partition here it is 1..3)
                if(count==1*ones) j1=i;
                if(count==2*ones) j2=i;
                if(count==3*ones) j3=i;

            }

        }
        //System.out.println(""+i1+","+i2+","+i2+",  "+j1+","+j2+","+j3);

        //take the partition of each array and compare..
        int[] a1 = Arrays.copyOfRange(arr,i1,j1+1);
        int[] a2 = Arrays.copyOfRange(arr,i2,j2+1);
        int[] a3 = Arrays.copyOfRange(arr,i3,j3+1);

        if(Arrays.equals(a1,a2)==false || Arrays.equals(a2,a3)==false) return invalid;
        //handle the trailing zero. if partition 3 has zero then it must be
        //we have to do -1 because we are using the index position
        int t1=0,t2=0,t3=0;
        t1=i2-j1-1;  //starting of second position - ending of first position - 1
        t2=i3-j2-1;
        t3=n-1-j3;  //entire length of array - 1 - ending of thrid position

        if(t3>t1 || t3>t2) return invalid;

        return new int[]{j1+t3, j2+t3+1};


    }
}
