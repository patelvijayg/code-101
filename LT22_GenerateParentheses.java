import java.util.*;

public class LT22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        generate(0,0,n,curr,result);
        return result;
    }
    public static void generate(int open, int close, int max, List<String> curr, List<String> result){
        if(open== max && close==max){
            StringBuilder sb =new StringBuilder();
            for (int i = 0; i < curr.size(); i++) {
                sb.append(curr.get(i));
            }
            result.add(sb.toString());
            return;
        }
        if(open<max){
            curr.add("(");
            generate(open+1,close,max,curr,result);
            curr.remove(curr.size()-1);
        }
        if(close<open){
            curr.add(")");
            generate(open,close+1,max,curr,result);
            curr.remove(curr.size()-1);
        }
    }
}
