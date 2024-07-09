
import java.util.Arrays;

class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int left = 1;
        int right = stalls[n-1] - stalls[0];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlace(stalls, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    public static boolean canPlace(int[] stalls, int k, int limit) {
        int placedCowCount = 1;
        int lastPlaced = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            int diff = stalls[i] - lastPlaced;
            if (diff >= limit) {
                placedCowCount++;
                lastPlaced = stalls[i];
            }
        }
        return placedCowCount >= k;
    }
}