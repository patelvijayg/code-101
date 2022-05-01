import java.util.Arrays;

public class LT435_NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if( intervals.length<=1) return 0;
        //Sort by start interval
        Arrays.sort(intervals, (a, b)-> a[0]-b[0] );
        //First Element would store in prevEnd
        int prevEnd=intervals[0][1];
        int result=0;
        //Start from second element as first is kept as prevEnd
        for(int i=1; i<intervals.length; i++){
            int currentStart=intervals[i][0];
            if(prevEnd > currentStart){
                result++;
                //Make sure prev end is min of both
                prevEnd = Math.min(intervals[i][1],prevEnd);
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return result;
    }
}
