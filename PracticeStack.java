import java.util.*;

public class PracticeStack {

    private class MyStack{
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        public void push(int val){

        }
        public int pop(){
            return 0;
        }

    }
    public static void main(String[] args) {


        PracticeStack driver = new PracticeStack();
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(5);
        st.push(6);

        System.out.println(st);
        driver.removeMiddleElement(st);
        System.out.println(st);
    }
    public void sortStack(Stack<Integer> stack){

        if(stack.isEmpty()) return;

        int tmp = stack.pop();
        sortStack(stack);
        insertElementAtSortPosition(stack,tmp);
    }
    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int tmp = stack.pop();
        reverseStack(stack);
        insertElementAtBottom(stack,tmp);
    }

    public void insertElementAtBottom(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int tmp = stack.pop();
        insertElementAtBottom(stack,val);
        stack.push(tmp);
    }
    public void insertElementAtSortPosition(Stack<Integer> stack, int val){
        if(stack.isEmpty() || stack.peek()<val){
            stack.push(val);
            return;
        }
        int tmp = stack.pop();
        insertElementAtBottom(stack,val);
        stack.push(tmp);
    }
    public void removeMiddleElement(Stack<Integer> stack){
        int middlePos= stack.size()/2;
        removeMiddleElementWithPosition(stack,middlePos);
    }
    private void removeMiddleElementWithPosition(Stack<Integer> stack, int middlePosition){
        if(middlePosition==0){
            stack.pop();
            return;
        }
        int tmp=stack.pop();
        middlePosition--;
        removeMiddleElementWithPosition(stack,middlePosition);
        stack.push(tmp);
    }

    private static class MinStack{
        public static void main(String[] args) {
            MinStack ms = new MinStack();
            ms.push(2);
            ms.getMin();
            ms.push(3);
            ms.push(1);
            ms.getMin();
            ms.push(4);
            ms.pop();
            ms.pop();
            ms.push(6);
            ms.pop();
            ms.getMin();
            ms.push(5);
            ms.push(-1);


            ms.getMin();
            ms.getMin();
        }
        private Stack<Integer> stack = new Stack<>();
        int min = 0;
        public MinStack() {
        }
        public void push(int item){
            if(stack.size()==0){
                min=item;
                stack.push(item);
            }else {
                if(item < min){
                    int newval = 2*item - min;
                    stack.push(newval);
                    min=item;
                }else {
                    stack.push(item);
                }
            }
        }
        public int getMin(){
            System.out.println(min);
            return min;
        }
        public int peek(){
            int newval = stack.peek();
            if(newval<min){
                int actual = 2*min - newval;
                return actual;
            }else {
                return newval;
            }
        }
        public int pop(){
            int newval = stack.pop();
            if(newval<min){
                int actual = 2*min - newval;
                return actual;
            }else {
                return newval;
            }
        }
    }
}
