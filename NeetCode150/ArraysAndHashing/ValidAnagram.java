package NeetCode150.ArraysAndHashing;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] frequencyArrS = new int[26];
        int[] frequencyArrT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = getAsciiCode(s.charAt(i)) - getAsciiCode('a');
            frequencyArrS[idx] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int idx = getAsciiCode(t.charAt(i)) - getAsciiCode('a');
            frequencyArrT[idx] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (frequencyArrS[i] != frequencyArrT[i]) {
                return false;
            }
        }

        return true;
    }

    public static int getAsciiCode(char ch) {
        return (int) ch;
    }
}
