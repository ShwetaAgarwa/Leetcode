class Solution {
    public int firstMissingPositive(int[] nums) {
         int n = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (num > 0) {
                map.put(num, true);
            }
        }
        
        // Find the first missing positive integer
        for (int i = 1; i <= n + 1; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        
        // If all integers from 1 to n are present, return n+1
        return n + 1;
    }
}