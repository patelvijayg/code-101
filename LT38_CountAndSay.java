public class LT38_CountAndSay {
    public String countAndSay(int n) {
        String res= "1";
        if(n==1) return res;
        while (n>1){
            res = countAndSay(res);
            n--;
        }
        return res;
    }

    private String countAndSay(String res) {
        StringBuilder sb = new StringBuilder();
        int counter=1;
        char prev = res.charAt(0);
        for (int i = 1; i <res.length() ; i++) {
            char curr = res.charAt(i);
            if(prev == curr){
                counter++;
            }else {
                sb.append(counter).append(prev);
                counter=1;
                prev=curr;
            }
        }
        //This is to handle the last char sequence which has not been added in for loop
        //due to last char can not had if condition pass hence we need to deal outside of loop
        sb.append(counter).append(prev);
        return sb.toString();
    }

}
