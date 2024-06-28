class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true; // 0 and 1 are perfect squares

        int left = 2; // no need to start at 0 since 0 and 1 are already handled
        int right = num / 2; // no need to go beyond num/2

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid; // cast to long to avoid overflow
            if (square == num) return true;
            if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
