import java.util.Stack;

public class LT1209_RemoveAllAdjacentDuplicatesInString {
//    Input: s = "deeedbbcccbdaa", k = 3
//    Output: "aa"
//    Explanation:
//    First delete "eee" and "ccc", get "ddbbbdaa"
//    Then delete "bbb", get "dddaa"
//    Finally delete "ddd", get "aa"
//
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty()) {
                Pair pair = new Pair(current, 1);
                stack.push(pair);
            } else {
                Pair top = stack.peek();
                if (top.ch == current) {
                    if (top.count + 1 == k) {
                        stack.pop();
                    } else {
                        top.count = top.count + 1;
                    }

                } else {
                    Pair pair = new Pair(current, 1);
                    stack.push(pair);
                }
            }

        }

        if (stack.isEmpty()) {
            return "";
        } else {

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                Pair pair = stack.pop();
                for (int i = 0; i < pair.count; i++)
                    sb.append(pair.ch);
            }
            return sb.reverse().toString();

        }

    }

    private class Pair {
        public char ch;
        public int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

    }
}
