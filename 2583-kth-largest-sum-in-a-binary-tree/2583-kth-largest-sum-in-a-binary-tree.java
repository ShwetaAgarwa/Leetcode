import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        
       
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<Long> levelSums = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            long levelSum = 0;
            
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                
                
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
           
            levelSums.add(levelSum);
        }
        
        Collections.sort(levelSums, Collections.reverseOrder());
        
        
        if (k > levelSums.size()) {
            return -1;
        }
        
        return levelSums.get(k - 1);
    }
}

