class Node {
    Node[] links;
    boolean flag;

    public Node() {
        links = new Node[26];
        flag = false;
    }

    boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch) {
        links[ch - 'a'] = new Node();
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class WordDictionary {

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean search(String word) {
        Node node = root;
        return search(word, 0, node);
    }
    public boolean search(String word, int idx, Node node) {
        if (idx == word.length()) {
            return node.isEnd();
        }
        if (word.charAt(idx) != '.') {
            if (!node.contains(word.charAt(idx))) {
                return false;
            } else {
                return search(word, idx + 1, node.get(word.charAt(idx)));
            }
        }    
        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null && search(word, idx + 1, node.get((char)(i + 'a')))) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */