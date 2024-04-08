class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
       int ans = 0;
        int n = nums.length;
        for(int i=0; i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((nums[k] - nums[j] == diff) && (nums[j] - nums[i] == diff) ){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}