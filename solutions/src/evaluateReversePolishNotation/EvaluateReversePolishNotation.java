package evaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.add(Integer.parseInt(token));
            } else {
                int secVal = stack.pollLast();
                int firstVal = stack.pollLast();

                switch (token) {
                    case "+" -> stack.addLast(firstVal + secVal);
                    case "-" -> stack.addLast(firstVal - secVal);
                    case "*" -> stack.addLast(firstVal * secVal);
                    default -> stack.addLast(firstVal / secVal);
                }
            }
        }

        return stack.pollLast();
    }
}
