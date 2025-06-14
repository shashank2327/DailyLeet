class Node {
    Node[] links;
    boolean flag;
    int cnt;
    public Node() {
        links = new Node[26];
        flag = false;
        cnt = 0;
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

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        // making a temp node so that my root do not move;
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                // create a new node
                node.put(word.charAt(i));
            }
            node.cnt++;

            // Move to the next node
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root; // Keeping the root fixed
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.contains(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public String longestPrefix(int count) {
        Node node = root;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while (true) {
            if (flag) {
                break;
            }
            Node temp = null;
            StringBuilder sb2 = new StringBuilder();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (node.contains(ch)) {
                    sb2.append(ch);
                    temp = node.get(ch);
                }
            }
            if (temp == null || sb2.toString().length() > 1 || node.cnt != count) {
                break;
            } else {
                node = temp;
                sb.append(sb2.toString());
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            if (str.equals("")) return "";
            trie.insert(str);
        }
        return trie.longestPrefix(strs.length);
    }
}