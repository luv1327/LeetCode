package NeetCode150.Stack;

import java.util.ArrayList;

public class ValidParathesis {
    public boolean isValid(String s) {
        int n = s.length();
        ArrayList<Character> stack = new ArrayList<>();
        for(int i = 0;i < n ;i++){
            char currentChar = s.charAt(i);
            if(isClosing(currentChar)){
                if(stack.size() > 0){
                    char openingBracket = stack.remove(stack.size() - 1);
                    if(!isMatching(openingBracket,currentChar)){
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                stack.add(currentChar);
            }
            
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    public static boolean isClosing(char bracket){
        if(bracket == ')' || bracket == '}' || bracket == ']'){
            return true;
        }
        return false;
    }

    public static boolean isMatching(char opening,char closing){
        if(opening == '(' && closing == ')'){
            return true;
        }else if(opening == '{' && closing == '}'){
            return true;
        }else if(opening == '[' && closing == ']'){
            return true;
        }
        return false;
    }
}
