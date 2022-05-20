import java.util.Arrays;
import java.util.Stack;

public class LT84_LargestRectangleHistogram {

    public static void main(String[] args) {
        LT84_LargestRectangleHistogram driver = new LT84_LargestRectangleHistogram();
        int[] heights = {2, 1, 6, 6, 6, 3};
        int area = driver.largestRectangleArea(heights);
        System.out.println(" result="+area);
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Stack<Integer> st = new Stack<>();
        //Find the left side smaller element
        for (int i = 0; i < n; i++) {
            //remove the items if you found bigger than or equals to current.
            //we have to use equal becaues same element will have same index if we remove
            //otherwise it will not give correct result.
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                left[i] = 0;
            }else {
                left[i]=st.peek()+1;
            }
            st.push(i);
        }
        st.clear();
        for (int i =n-1; i>=0; i--) {
            while (st.size() > 0 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                right[i] = n-1;
            }else {
                right[i]=st.peek()-1;
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(heights));
        int max=0;
        for (int i = 0; i < n; i++) {
            int diff = (right[i]-left[i]+1)*heights[i];
            if(diff>max)max=diff;
            //System.out.print(diff  + ",");
        }
        return max;
    }
}
