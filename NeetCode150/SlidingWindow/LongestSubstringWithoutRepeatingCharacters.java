package NeetCode150.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxWindow = 0;
        while (right < n){
            if(hm.containsKey(s.charAt(right)) && hm.get(s.charAt(right)) >= left){
                left = hm.get(s.charAt(right)) + 1;
            }
            hm.put(s.charAt(right),right);
            int currentWindow = right - left + 1;
            maxWindow = Math.max(maxWindow,currentWindow);
            right +=1;
        }
        return maxWindow;
    }
}
