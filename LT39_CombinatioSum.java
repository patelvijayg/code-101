import java.util.*;

public class LT39_CombinatioSum {
    List<List<Integer>> result=null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Input: candidates = [2,3,5], target = 8
        //Output: [[2,2,2,2],[2,3,3],[3,5]]
        //Note only combination allowed not permutation eg.[2,3,3] but not[3,2,3] or [3,3,2]
        result = new ArrayList();
        List<Integer> curr = new ArrayList();
        getcomb(0,curr,target,candidates);
        return result;
    }
    public void getcomb(int i, List<Integer> curr, int target,int[] arr){
        if(i>=arr.length) return;
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList(curr));
            return;
        }

        //include this candidate
        curr.add(arr[i]);
        getcomb(i,curr,target-arr[i],arr);
        curr.remove(curr.size()-1);
        //exclude this candiate and move to next one
        getcomb(i+1,curr,target,arr);
    }
}
