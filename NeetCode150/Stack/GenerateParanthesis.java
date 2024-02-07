package NeetCode150.Stack;

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,n,"",ans);
        return ans;
    }

    public static void generate(int open,int close,String prev,List<String> ans){
        if(open == 0 && close == 0){
            ans.add(prev);
        }
        if(open > 0){
            generate(open-1,close,prev + "(",ans);
        }
        if(close > open){
            generate(open,close-1,prev + ")",ans);
        }
    }
}