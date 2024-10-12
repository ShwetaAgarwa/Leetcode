import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        
        
        for (int[] interval : intervals) {
            events.add(new int[] {interval[0], 1});
            events.add(new int[] {interval[1] + 1, -1}); 
        }
       
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int maxGroups = 0;
        int currentGroups = 0;
        for (int[] event : events) {
            currentGroups += event[1];
            maxGroups = Math.max(maxGroups, currentGroups);
        }
        
        return maxGroups;
    }
}
