class Node {
    Node[] links;
    boolean flag;

    public Node() {
        links = new Node[26];
        flag = false;
    }

    // checks if node contains a specific key
    boolean contains(char ch) {
        return links[ch - 'a'] == null;
    }
    
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
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

class Trie {
    
    private final Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        // making a temp node so that my root do not move;
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                // create a new node
                node.put(word.charAt(i), new Node());
            }
            // Move to the next node
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root; // Keeping the root fixed
        for (int i = 0; i < word.length(); i++) {
            if (node.contains(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.contains(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */