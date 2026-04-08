class PrefixTree {
    TreiNode root;
    public PrefixTree() {
        root = new TreiNode();
    }

    public void insert(String word) {
        TreiNode node = root; 
        int ind = -1;
        for(char ch: word.toCharArray()){
            ind = ch-'a';
            if(node.children[ind]==null){
                node.children[ind] = new TreiNode();
            }
            node = node.children[ind];
        }

        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TreiNode node = root; int ind;
        for(char ch: word.toCharArray()){
            ind = ch-'a';
            if(node.children[ind]==null){
                return false;
            }
            node = node.children[ind];
        }

        return node.isEndOfWord;

    }

    public boolean startsWith(String prefix) {
        TreiNode node = root; int ind;
        for(char ch: prefix.toCharArray()){
            ind = ch-'a';
            if(node.children[ind]==null){
                return false;
            }
            node = node.children[ind];
        }

        return true;
    }
}

class TreiNode{
    TreiNode[] children;
    boolean isEndOfWord;
    TreiNode(){
        children = new TreiNode[26];
        isEndOfWord = false;
    }
}
