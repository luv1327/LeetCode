package NeetCode150.SlidingWindow;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] hmOne = new int[256]; // Using an array for frequency tracking
        int[] hmTwo = new int[256];

        for (int i = 0; i < t.length(); i++) {
            char chr = t.charAt(i);
            hmOne[chr]++;
        }

        int left = 0;
        int right = 0;
        int maxWindow = Integer.MAX_VALUE; // Initialize maxWindow to a large value
        String ans = "";

        while (right < s.length()) {
            hmTwo[s.charAt(right)]++;

            while (isMatching(hmOne, hmTwo)) {
                int currentWindow = right - left + 1;
                if (currentWindow < maxWindow) {
                    maxWindow = currentWindow;
                    ans = s.substring(left, right + 1);
                }

                hmTwo[s.charAt(left)]--;
                left++;
            }

            right++;
        }

        return ans;
    }

    public static boolean isMatching(int[] hmOne, int[] hmTwo) {
        for (int i = 0; i < 256; i++) {
            if (hmTwo[i] < hmOne[i]) {
                return false;
            }
        }
        return true;
    }
}
