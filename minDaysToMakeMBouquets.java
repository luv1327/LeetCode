import java.util.Arrays;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (((long)m * k) > n) return -1;
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

    public boolean canMake(int[] bloomDay, int m, int k, int day) {
        int flowerCount = 0;
        int bouquets = 0;
        
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowerCount++;
                if (flowerCount == k) {
                    bouquets++;
                    flowerCount = 0;
                }
            } else {
                flowerCount = 0;
            }
        }
        
        return bouquets >= m;
    }
}
