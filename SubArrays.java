import java.util.*;

public class SubArrays {
    public static void main(String[] args) {
        List<Integer> comList = Arrays.asList(4,1,2,3,4);
        getCombination(comList);
        int[]com = {3,1,2,3,4};
        getCombination(com);
    }
    public static List<List<Integer>> getCombination(List<Integer> list){
        int len=list.size();
        Set<List<Integer>> allComb = new HashSet<>();
        for (int i = 0; i <len ; i++) {
            List<Integer> prev = new ArrayList<>();
            for (int j = i; j <len ; j++) {
                List<Integer> curr = new ArrayList<>(prev);
                curr.add(list.get(j));
                allComb.add(curr);
                prev=curr;
            }
        }
        System.out.println(allComb);
        return new ArrayList<>(allComb);
    }
    public static List<List<Integer>> getCombination(int[] arr){
        int len=arr.length;
        Set<List<Integer>> allComb = new HashSet<>();
        for (int i = 0; i <len ; i++) {
            List<Integer> prev = new ArrayList<>();
            for (int j = i; j <len ; j++) {
                List<Integer> curr = new ArrayList<>(prev);
                curr.add(arr[j]);
                allComb.add(curr);
                prev=curr;
            }
        }
        System.out.println(allComb);
        return new ArrayList<>(allComb);
    }
}
