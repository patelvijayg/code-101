import java.util.*;

public class Practice2 {
    public static void main(String[] args) {
        Practice2 p = new Practice2();
        int[][] candidates =new int[][] {{1,5},{10,11},{12,18},{20,25},{30,32}};
       // int[] candidates =new int[] {19,10,15}; //11
        //int[] candidates =new int[] {6,7,8}; //11
        //int rr =p.maxConsecutive(10,30,candidates);
       // int rr =p.maxConsecutive(6,8,candidates);
//        char[][] grid=new char[][]{{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
//        //boolean r3= p.hasValidPath(grid);
//        int[] arr=new int[]{1,3,1,2,0,5};
//        int[] r3 = maxSlidingWindow(arr,3);
//        System.out.println("result="+Arrays.toString(r3));

        int[][] mat = new int[][]{ {1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = new int[][]{ {1,2,3},{4,5,6},{7,8,9}};
        printmat(mat);
        System.out.println();
        diagrtol(mat);
        System.out.println();
        printmat(mat);
        diagltor(mat2);
        System.out.println();
        printmat(mat2);
    }
    public static void diagltor(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j]=i+j;
            }
        }
    }
    public static void diagrtol(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j]=mat.length-i+j-1;
            }
        }
    }
    public static void printmat(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(k==1) return nums;
        int n=nums.length, left=0;
        //Monotonic stack with fix window size. while fix window size we must use index of array
        //to store in stack because we can check out of bounce by index differece.
        ArrayDeque<Integer> dq = new ArrayDeque();
        int[] res = new int[n-k+1];

        for(int i=0; i<n; i++){
            int curr=nums[i];
            //since we adding one element at time window can be only bounce by 1 element
            if(dq.size()>0 && dq.peek() == i-k ) {
                dq.removeFirst();
            }

            while(dq.size()>0 && nums[dq.peekLast()]<curr){
                dq.removeLast();
            }

            dq.addLast(i);
            if(i+1>=k){
                res[left]=nums[dq.peekFirst()];
                left++;
            }
        }
        return res;

    }
    public static int firstDuplicate(int[] arr){
        //you are making position as duplicate value once it is appear
        for (int i = 0; i < arr.length; i++) {
            int newPosition=Math.abs(arr[i])-1;
            if(arr[newPosition]<0){
                return Math.abs(arr[i]);
            }else {
                arr[newPosition]=-arr[newPosition];
            }
        }
        return -1;
    }

    private Map<String,Boolean> map=new HashMap();

    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0] !='(' || grid[grid.length-1][grid[0].length-1] !=')') return false;
        boolean result= dfs(grid,0,0,0);
        return result;
    }

    public boolean dfs(char[][] grid, int r, int c,int bal){
        int m = grid.length, n=grid[0].length;
        if(r>=m || c>=n || bal<0) return false;
        String key=r+"-"+c+"-"+bal;
        if(map.containsKey(key)){
            return map.get(key);
        }
        char curr = grid[r][c];
        bal = bal + (curr=='(' ? 1 : -1);
        if(r==m-1 && c==n-1 && bal==0){
            map.put(key,true);
            return true;
        }
        if(bal<0){
            map.put(key,false);
            return false;
        }
        boolean valid = dfs(grid,r+1,c,bal) || dfs(grid,r,c+1,bal);
        map.put(key,valid);
        return valid;
    }

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int prevStart=bottom;
        for (int i=0; i<special.length;i++){
            int start=prevStart-special[i];
            int end=special[i];
            System.out.println(end-start);

        }
        int count=0;
        int maxcount=0;

        maxcount=Math.max(count,maxcount);
        return maxcount;
    }
    public int maxConsecutive1(int bottom, int top, int[] special) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <special.length ; i++) {
            set.add(special[i]);
        }
        int count=0;
        int maxcount=0;
        for (int i=bottom;i<=top;i++) {
            if (set.contains(i)) {
                maxcount=Math.max(count,maxcount);
                count=0;
            }else{
                count++;
            }
        }
        maxcount=Math.max(count,maxcount);
        return maxcount;
    }
//    public int largestCombination(int[] candidates) {
//        int target=candidates[0];
//        List<List<Integer>> r =combinationSum2(candidates,target);
//        System.out.println(r);
//        return 0;
//    }
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<List<Integer>> res = new ArrayList<>();
//
//        solve(1, candidates, target, new ArrayList<>(), res);
//        return res;
//    }
    public void solve(int start, int nums[], int target, List<Integer> temp, List<List<Integer>> res){
        if(target > 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target > 0){
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i - 1]) continue;
                temp.add(nums[i]);
                solve(i + 1, nums, target & nums[i], temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public int largestCombination(int[] candidates) {
        List<Integer> l = new ArrayList<>();
        int n = candidates.length;

        for (int i = 0; i < (1<<n); i++)
        {
            //System.out.print("{ ");
            int result=0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    int prev=candidates[j];
                    if(j>0){
                      result=prev & candidates[j];
                      prev=candidates[j];
                    }
                    //System.out.print(candidates[j] + " ");
                }
            }
            l.add(result);
            //System.out.println("}");
        }
        System.out.println(l);
        return 0;
    }
    private class TileMap{
        int start;
        int end;
        int presum;
        int len;

        public TileMap(int start, int end, int presum) {
            this.start = start;
            this.end = end;
            this.presum = presum;
            this.len=end-start+1;
        }
    }
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        TreeSet<Integer> setTileEnd = new TreeSet<>();
        int[] presum = new int[tiles.length];
        TreeMap<Integer,TileMap> map = new TreeMap<>();

        int sum=0;
        for (int i = 0; i < tiles.length; i++) {

            setTileEnd.add(tiles[i][1]);
            int tileLen=tiles[i][1]-tiles[i][0]+1;
            presum[i]=sum+tileLen;
            map.put(tiles[i][0],new TileMap(tiles[i][0],tiles[i][1],sum));
            sum=presum[i];
        }

        for (int i = 0; i < tiles.length ; i++) {
            int start=tiles[i][0];
            int end=start+carpetLen-1;
            if(end < tiles[i][1]){
                return carpetLen;
            }


            Integer lastTile=map.ceilingKey(end);
            if(lastTile==null){
                lastTile=map.lastKey();
            }else {
                lastTile=map.floorEntry(lastTile-1).getKey();
            }
            int currsum=map.get(start).presum;
            int nextsum=map.get(lastTile).presum;
            int diff = map.get(lastTile).len-(map.get(lastTile).end-end+1);
            System.out.println(diff);
            System.out.println("prefix="+presum[i]);
            System.out.println(currsum + " "+lastTile);


        }

        return 0;
    }
}
