import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // minimum speed should be at least 1
        int right = Arrays.stream(piles).max().getAsInt(); // maximum speed is the size of the largest pile
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / k);
        }
        return totalHours <= h;
    }
}
