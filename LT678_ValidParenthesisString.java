import java.util.Stack;

public class LT678_ValidParenthesisString {
    public static void main(String[] args) {
        LT678_ValidParenthesisString driver = new LT678_ValidParenthesisString();
        boolean result=driver.checkValidString("(*))");
        System.out.println(result);
    }
    public boolean checkValidString(String s) {
        //Declare 2 stack for handling * char
        Stack<Integer> open = new Stack<>();
        Stack<Integer> any = new Stack<>();

        //Fill the open stack by adding index position and removing if close bracket comes
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr=='*') {
                any.push(i);
            }else if(curr=='('){
                open.push(i);
            }else {
                //if closing bracket present then remove it and if not check in star stack
                if(open.size()>0){
                    open.pop();
                }else if(any.size()>0){
                    any.pop();
                }else {
                    return false;
                }
            }
        }
        //if open stack is empty mean all brackets matchs and whatever * remainins can be treat as empty string

        //But if open bracket present then we need to check any * present to handle it
        if(open.size()>0 && any.size()==0) return false;

        //we will pick one by one index of open stack and check corresponding * matches in other stack
        while (open.size()>0){
            int posOpen = open.pop();
            //if * is not present and we had open bracket then also it is invalid case;
            if(any.size()>0){
                int posStar = any.pop();
                //If open bracket postion is coming after last * index mean it is invalid
                if(posOpen>posStar) return false;
            }else {
                return false;
            }
        }

        return true;
    }
}
