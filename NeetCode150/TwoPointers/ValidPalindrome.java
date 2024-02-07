package NeetCode150.TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                if(Character.isUpperCase(s.charAt(i))){
                    stringBuilder.append(Character.toLowerCase(s.charAt(i)));
                }else{
                    stringBuilder.append(s.charAt(i));
                }
            }
        }
        
        return valid(stringBuilder);
    }
    public static boolean valid(StringBuilder stringBuilder){
        int left = 0;
        int right = stringBuilder.length() - 1;
        while (left < right){
            boolean isMatching = stringBuilder.charAt(left) == stringBuilder.charAt(right);
            if(!isMatching){
                return false;
            }
            left +=1;
            right -=1;
        }
        return true;
    }
}
