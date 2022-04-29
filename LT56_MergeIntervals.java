import java.util.*;

public class LT56_MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result_expected = {{1, 6}, {8, 10}, {15, 18}};
        LT56_MergeIntervals driver = new LT56_MergeIntervals();
        int[][] result_actual = driver.merge(intervals);
        Arrays.sort(result_actual, (a, b) -> a[0] - b[0]);
        Arrays.sort(result_expected, (a, b) -> a[0] - b[0]);
        for(int i=0; i<result_actual.length;i++){
            System.out.println(Arrays.toString(result_actual[i]) + " == "+ Arrays.toString(result_expected[i]));
        }
    }

    public int[][] merge(int[][] intervals) {
        ///Sort the interval base on start time.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> st = new Stack();
        final int START=0;
        final int END=1;
        for (int[] current : intervals) {
            //insert first element as is
            if (st.size() == 0) {
                st.push(current);
            } else {
                int[] lastInterval = st.peek();
                ///chcek the last element of stack has end time overlap with curr start time
                if (current[START] <= lastInterval[END]) {
                    //End time should be max of both end time
                    lastInterval[END] = Math.max(lastInterval[END], current[END]);
                } else {
                    //in this case there is not overalp so add simply
                    st.push(current);
                }
            }
        }
        int[][] result = new int[st.size()][2];
        int count = 0;
        while (!st.isEmpty()) {
            result[count++] = st.pop();
        }
        return result;
    }
}
