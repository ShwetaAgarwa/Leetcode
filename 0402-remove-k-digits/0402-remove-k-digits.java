import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && ch < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        // Remove remaining digits from the stack if k is not zero
        while (k > 0) {
            stack.pop();
            k--;
        }
        // Build the result string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        // Return "0" if the result is empty, otherwise return the result
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
