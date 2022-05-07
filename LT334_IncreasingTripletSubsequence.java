public class LT334_IncreasingTripletSubsequence {
    //Either number smaller than first or smaller than second or third.
    //Compare in sequence first, second,

    public boolean increasingTriplet(int[] nums) {
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num: nums) {
            //if current is smaller than first number.. assign in first
            if (num <= firstSmallest) {
                firstSmallest = num;
            //else if number is smaller than second.. assign in second
            } else if (num <= secondSmallest) {
                secondSmallest = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
