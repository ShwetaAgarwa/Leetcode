class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1;
        int maxI = -1;
        int CI = -1;
        long res = 0;
        int n = nums.length;
        for(int current = 0; current<n; current++){
            if(nums[current]==minK){
                minI = current;
            }  
            if(nums[current]==maxK){
                maxI = current;
            }
            //check if the element is out of  bound 
            if(nums[current]<minK || nums[current]>maxK){
                CI = current;
            }
            if(minI!=-1 && maxI!=-1){
                int smaller = Math.min(minI,maxI);
                if((smaller - CI) >0) {
                    res = res+(smaller - CI); 
                }
            }
        }
        return res;
        
    }
}