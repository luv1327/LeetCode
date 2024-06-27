class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
