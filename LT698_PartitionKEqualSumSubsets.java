public class LT698_PartitionKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] visited = new boolean[nums.length];
        int sum=0;
        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            sum=sum+curr;
        }
        if(sum%k != 0) return false;
        int target=sum/k;
        boolean result = dfs(0,k,0,target,nums,visited);
        return result;
    }

    private boolean dfs(int pos, int k, int currentSum,int target, int[] nums, boolean[] visited){
        //k==0 also works but This is to avoid TLE
        if(k==1) return true;
        //This is also not require but to avoid TLE
        if(currentSum>target) return false;
        if(currentSum ==target){
            return dfs(0,k-1,0,target,nums,visited);
        }
        for(int j=pos; j<nums.length;j++){
            if(visited[j] || currentSum + nums[j]>target ){
                continue;
            }
            visited[j]=true;
            if(dfs(j+1,k,currentSum+nums[j],target,nums,visited)){
                return true;
            }
            visited[j]=false;

        }
        return false;
    }
}
