class TreiNode{
    TreiNode[] children;
    boolean isEndOfWord;
    TreiNode(){
        children = new TreiNode[26];
        isEndOfWord = false;
    }
}

class WordDictionary {
    TreiNode root;
    public WordDictionary() {
        root = new TreiNode();
    }

    public void addWord(String word) {
        TreiNode node = root; int ind;
        for(char ch: word.toCharArray()){
            ind = ch - 'a';
            if(node.children[ind]==null){
                node.children[ind] = new TreiNode();
            }
            node = node.children[ind];
        }

        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(0, word, root);
    }

    public boolean dfs(int start, String str, TreiNode node){
        if(node == null)
            return false;
        
         if(start==str.length())
            return node.isEndOfWord;

        char ch = str.charAt(start);

        if(ch!='.'){
           return dfs(start+1, str, node.children[ch-'a']);
        }
        else
        {
            for(int j=0; j<26; j++){
                if(node.children[j]!=null){
                   if(dfs(start+1, str, node.children[j]))
                        return true;
                }
            }

        }

        return false;
        
    }
}
