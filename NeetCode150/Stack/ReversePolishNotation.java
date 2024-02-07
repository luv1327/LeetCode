package NeetCode150.Stack;

import java.util.ArrayList;
import java.util.List;

class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        List<Integer> stack = new ArrayList<>();
        for (String chr : tokens) {
            if (isOperator(chr)) {
                int stackSize = stack.size();
                int num2 = stack.remove(stackSize - 1);
                int num1 = stack.remove(stackSize - 2);
                int ansNum = runArithmeticOperation(num1, num2, chr);
                stack.add(ansNum);
            } else {
                stack.add(Integer.parseInt(chr));
            }
        }
        int stackSize = stack.size();
        return stack.get(stackSize - 1);
    }

    public static boolean isOperator(String chr) {
        return chr.equals("+") || chr.equals("-") || chr.equals("*") || chr.equals("/");
    }

    public static int runArithmeticOperation(int num1, int num2, String operator) {
        double ansNum = 0;
        if (operator.equals("+")) {
            ansNum = num1 + num2;
        } else if (operator.equals("-")) {
            ansNum = num1 - num2;
        } else if (operator.equals("*")) {
            ansNum = num1 * num2;
        } else {
            ansNum = num1 / num2;
        }
        return (int) Math.floor(ansNum);
    }
}

