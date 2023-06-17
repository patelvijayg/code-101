public class TrieSample {

    public static void main(String[] args) {
        int distCount = distinctSubstring("abcabc");
        System.out.println(distCount);
        TrieSearch trie = new TrieSearch();
        trie.insert("apple");
        trie.insert("apples");
        System.out.println(trie.startWith("appl"));
    }
    public static int distinctSubstring(String word) {
        int count=0;
        NodeDistCount root = new NodeDistCount();
        for(int i=0; i<word.length(); i++){
            NodeDistCount node = root;
            for(int j=i; j<word.length(); j++){
                char c = word.charAt(j);
                if(node.containsKey(c)==false){
                    node.put(c, new NodeDistCount());
                    count++;
                }
                node=node.get(c);
            }
        }
        return count;
    }

    public static class TrieSearch{
        private NodeSearch root = new NodeSearch();

        public TrieSearch() {
            root = new NodeSearch();
        }
        public void  insert(String word){
            NodeSearch node = root;
            for (int i = 0; i <word.length() ; i++) {
                char c = word.charAt(i);
                if(node.containsKey(c)==false){
                    node.put(c,new NodeSearch());
                }
                node=node.get(c);
            }
            node.setEnd();
        }
        public boolean search(String word){
            NodeSearch node = root;
            for (int i = 0; i <word.length() ; i++) {
                char c = word.charAt(i);
                if(node.containsKey(c)==false){
                    return false;
                }
                node=node.get(c);
            }
            return node.isEnd()==true;

        }
        public boolean startWith(String word){
            NodeSearch node = root;
            for (int i = 0; i <word.length() ; i++) {
                char c = word.charAt(i);
                if(node.containsKey(c)==false){
                    return false;
                }
                node=node.get(c);
            }
            return true;

        }
    }
    public static class NodeSearch{
        private NodeSearch[] links = new NodeSearch[26];
        private boolean end=false;
        public boolean isEnd() {
            return end;
        }
        public void setEnd() {
            this.end = true;
        }
        public boolean containsKey(char c){
            return links[c-'a']!=null;
        }
        public NodeSearch get(char c){
            return links[c-'a'];
        }
        public void put(char c, NodeSearch n){
            links[c-'a']=n;
        }

    }

    private static class NodeDistCount {
        public NodeDistCount[] links = new NodeDistCount[26];
        public boolean containsKey(char c){
            return links[c-'a']!=null;
        }
        public NodeDistCount get(char c){
            return links[c-'a'];
        }
        public void put(char c, NodeDistCount n ){
            links[c-'a']=n;
        }
    }
}
