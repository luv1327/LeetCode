class Solution {
    public int passThePillow(int n, int time) {
        // Calculate the cycle length: forward to n and backward to 1
        int cycleLength = 2 * (n - 1);

        // Calculate the effective time within one cycle
        int effectiveTime = time % cycleLength;

        // Determine the person holding the pillow based on the effective time
        if (effectiveTime < n) {
            // Moving forward in the line
            return effectiveTime + 1;
        } else {
            // Moving backward in the line
            return 2 * n - effectiveTime - 1;
        }
    }
}

