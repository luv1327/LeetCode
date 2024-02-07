package NeetCode150.SlidingWindow;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] freqs1 = generateFreqArr(s1);
        int[] freqs2 = new int[26];
        int left = 0;
        int right = s1.length() - 1;
        
        for (int i = left; i <= right; i++) {
            freqs2[s2.charAt(i) - 'a']++;
        }

        while (right < s2.length()) {
            if (matchFreq(freqs1, freqs2)) {
                return true;
            }
            
            // Update freqs2 for the sliding window
            if (right < s2.length() - 1) {
                freqs2[s2.charAt(right + 1) - 'a']++;
            }
            freqs2[s2.charAt(left) - 'a']--;
            
            left++;
            right++;
        }
        return false;
    }

    public static int[] generateFreqArr(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
        }
        return freq;
    }

    public static boolean matchFreq(int[] nums1, int[] nums2) {
        for (int i = 0; i < 26; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
