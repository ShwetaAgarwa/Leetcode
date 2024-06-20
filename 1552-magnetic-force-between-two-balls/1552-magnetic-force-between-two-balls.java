import java.util.Arrays;

public class Solution {

    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int minForce = 1;
        int maxForce = position[n - 1] - position[0]; // This value is the maximum possible distance

        int result = 0;
        while (minForce <= maxForce) {
            int midForce = minForce + (maxForce - minForce) / 2;

            if (possibleToPlace(midForce, position, m)) {
                result = midForce;
                minForce = midForce + 1;
            } else {
                maxForce = midForce - 1;
            }
        }

        return result;
    }

    private boolean possibleToPlace(int force, int[] position, int m) {
        int count = 1; // Place the first ball at the first position
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= force) {
                count++;
                lastPos = position[i];
                if (count == m) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(solution.maxDistance(position, m)); // Output should be 3
    }
}

