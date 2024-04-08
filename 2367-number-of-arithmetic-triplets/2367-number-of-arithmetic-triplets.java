import java.util.HashSet;

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(set.contains(nums[i] - diff) && set.contains(nums[i] - 2 * diff)) {
                ans++;
            }
            set.add(nums[i]); 
        }
        return ans;
    }
}