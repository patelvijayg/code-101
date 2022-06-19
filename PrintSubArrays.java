import java.util.*;

public class PrintSubArrays {
    public static void main(String[] args) {
        List<Integer> comList = Arrays.asList(4,1,2,3,4);
        getCombination(comList);
        int[]com = {3,1,2,3,4};
        getCombination(com);
    }
    public static void fill2darray(){
        int n=3,m=4;
        int[][] dp = new int[n][m];
        for(int[] d : dp) Arrays.fill(d,-1);
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
    public static int maxWindow(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int len=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
            int diff=sum-target;
            if(map.containsKey(diff)){
                len=Math.max(len, i - map.get(diff));
            }
            if(map.containsKey(sum)==false){
                map.put(sum,i);
            }
        }
        if(len==Integer.MIN_VALUE) return -1;
        return len;
    }
    public static int minWindow(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int len=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
            int diff=sum-target;
            if(map.containsKey(diff)){
                len=Math.min(len, i - map.get(diff));
            }
            map.put(sum,i);
        }
        if(len==Integer.MAX_VALUE) return -1;
        return len;
    }
}
