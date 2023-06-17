import java.util.*;

public class PracticeBS {

    public static void main(String[] args) {
        testing();
        int[] arr1 = {1,2,3,4,5,5,5,5,5,5,6,7,8,9};
        PracticeBS driver = new PracticeBS();
        int pos=driver.firstIndex(arr1,0);
        System.out.println(pos);
        System.out.println(Arrays.toString(arr1));
        int[] rot1 = {1,2,3,4,6,7,10,10,10,15};
        System.out.println(driver.findMin(rot1));
        System.out.println(driver.findFloor(rot1,0));
        System.out.println(driver.findCeil(rot1,16));
        int[] mindif={1,2,5,10,15,22};
        System.out.println(driver.mindiff(mindif,-1));
        boolean issquar=driver.isPerfectSquare(1);
        System.out.println("isperfect squaar"+issquar);
    }
    public int firstIndex(int[] arr, int val){
        int ans=-1;
        int n=arr.length,left=0, right=n-1;
        //conditoin shoule be lesser or equals because you need to check last element also
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==val){
                ans=mid;
                right=mid-1;
            }else if( val < arr[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }

        }
        return ans;
    }
    public int lastIndex(int[] arr, int val){
        int ans=-1, n=arr.length,left=0,right=n-1;
        while (left<=right){
            int mid= left + (right-left)/2;
            if(val == arr[mid]){
                ans=mid;
                left=mid+1;
            }else if(val < arr[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    public int findMin(int[] arr){

        int ans=0;
        int n=arr.length, left=0, right=n-1;

        while (left<=right){
            int mid = left + (right-left)/2;
            int prev = (mid+1)%n;
            int next = (mid-1+n)%n;
            //compare both side of mid element and if it happens to small then both then it is answer
            if(arr[mid] < arr[next] && arr[mid] < arr[prev] ){
                return mid;
            //this is important because you need to skip right half first as you
            //searching smaller element. it matters only when array is not rotated.
            //non rotated array has both else valid case so we need to right else case in correct order
            }else if ( arr[mid] <= arr[right]){
                right=mid-1;
            }else {
                left=mid+1;
            }


        }

        return -1;
    }

    public int findFloor(int[] arr, int val){
        int ans=0;
        int n=arr.length,left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==val){
                return arr[mid];
            }else if( val < arr[mid]){
                right=mid-1;
            }else {

                left=mid+1;
            }
        }
        right=Math.max(0,right);
        return arr[right];
    }

    public int findCeil(int[] arr, int val){
        int ans=Integer.MAX_VALUE, n=arr.length,left=0,right=n-1;
        while (left<=right){
            int mid=left + (right-left)/2;
            if( arr[mid]==val){
                return arr[mid];
            }else if(val<arr[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }

        }
        left=Math.min(left,n-1);
        return arr[left];
    }

    public int mindiff(int[] arr, int target){
        int n=arr.length, left=0,right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                return 0;
            }else if(target < arr[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        left=Math.min(n-1,left);
        right=Math.max(0,right);
        return Math.min(Math.abs(arr[left]-target),Math.abs(arr[right]-target) );
    }

    public int allocateBook(int[] book, int maxStudent){
        //set the low value as maximum and high value as totalsum
        int totalpage=0, maxpage=Integer.MIN_VALUE;
        for (int i = 0; i <book.length; i++) {
            totalpage=totalpage+book[i];
            maxpage=Math.max(maxpage,book[i]);
        }

        int left=maxpage,right=totalpage;
        int ans=0;
        while (left<=right){
            //find the mid value pages which can be check whether possible or not.
            int mid = left+(right-left)/2;
            if(isPossibleDistribution(book,mid,maxStudent) ){
                //since it is possible we can try for another smaller value
                right=mid-1;
                //it is one of the answer and look for another better answer
                ans=mid;
            }else {
                //this distribution is not possible so we need to give more pages
                //to student so increase low value
                left=mid+1;
            }
        }

        return ans;
    }
    public boolean isPossibleDistribution(int[]book, int maxload, int maxStudent){
        int studentCount=1;
        int sum=0;
        for (int i = 0; i < book.length; i++) {
            sum=sum+book[i];
            if(sum > maxload){
                studentCount++;
                sum=book[i];
            }
        }
        return studentCount<=maxStudent;
    }

    public boolean isPerfectSquare(int num) {
        //Declare left=1 because 0 will not work.
        int left=1, right=num;
        while(left<=right){
            int mid= left+(right-left)/2;
            if(mid*mid == num){
                return true;
                // Trick you can not do mid*mid < num but you can do mid < num/mid which works fine.
            }else if (num/mid < mid){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;

    }

    public int mySqrt(int x) {
        //return floor of square value
        if(x==0) return 0;
        if(x==1) return 1;

        int left=2,right=x;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid*mid==x){
                return mid;
            }else if( x/mid < mid ){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left-1;

    }

    public int findKthPositive(int[] arr, int k) {
        /*
            LT1539. Kth Missing Positive Number
            Input: arr = [2,3,4,7,11], k = 5
            Output: 9
            Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
         */

        //Crux of this problem is you need to find total missing number till here by substrating value-index-1
        int n=arr.length,left=0, right=n-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            //find the total missing number till this position.
            int midval=arr[mid]-mid-1;
            //if it is matches mean we can till here missing number matches so
            //answer must lying beteen left and mid. so now lets shrink more this window
            if(midval == k){
                right=mid-1;
            }else if (k < midval){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        //when we break the while loop our right points has became base number
        //and we need to add value to get missing number.
        //to calculate this we can get total missing on this and we substract from k and
        //finally we need to add that to current position value.

        if(right<0) return k;
        int missingTillHere=arr[right]-right-1;
        return arr[right] + (k - missingTillHere);

    }

    public int countNegatives(int[][] grid) {
        //LT1351. Count Negative Numbers in a Sorted Matrix
        //We need to start from bottom left corner and compare value
        int n=grid.length,m=grid[0].length;
        //start from last row and first column
        int r=n-1,c=0,cnt=0;

        while(r>=0 && c<m){
            //if current cell is negative then remaining all cell of this row
            //are negative and lets change the row after that
            if(grid[r][c]<0){
                cnt = cnt + (m-c);
                r--;
            }else{
                //if current cell is not negative then lets move toward negative value ->>
                c++;
            }

        }
        return cnt;

    }

    public boolean judgeSquareSum(int c) {
        /*
            633. Sum of Square Numbers
            Input: c = 5
            Output: true
            Explanation: 1 * 1 + 2 * 2 = 5
         */
        //we can break down this problem in to a^2+b^2=c ==> b^2=c-a^2
        //a**2 + b**2 = c hence
        Set<Integer> set = new HashSet();
        int max=(int)Math.sqrt(c);
        for(int a=0; a<=max+1; a++){

            //calclulate a**2
            int newval = a*a;
            //this is complementarty value
            int remaining=c-a*a;

            set.add(newval);
            if(set.contains(remaining)){
                return true;
            }
        }
        return false;
    }
    public static void testing(){
        int[] arr={-1,-1,0,2,2,2,2,2,3,5,7,9,11,13,15,17,18};
        System.out.println(arr.length);
        int i=Arrays.binarySearch(arr,2);

        System.out.println("position="+i);
    }
}
