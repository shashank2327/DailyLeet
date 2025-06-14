class Node {
    Node[] links;
    boolean flag;

    public Node() {
        links = new Node[26];
        flag = false;
    }

    boolean contains(char ch) {
        return (links[ch - 'a'] != null);
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

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
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
}

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length, m = board[0].length;
        List<String> ls = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] vis = new boolean[n][m];
                vis[i][j] = true;
                dfs(board, i, j, vis, trie, ls, set,  "" + board[i][j]);
            }
        }

        return ls;
    }

    private void dfs(
        char[][] board, 
        int i, 
        int j, 
        boolean[][] vis, 
        Trie trie, 
        List<String> ls,
        Set<String> set,
        String s
    ) 
    {
        if (!trie.startsWith(s)) return;

        if (trie.search(s) && !set.contains(s)) {
            ls.add(s);
            set.add(s);
        }

        for (int k = 0; k < 4; k++) {
            int nr = i + dx[k];
            int nc = j + dy[k];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && !vis[nr][nc]) {
                vis[nr][nc] = true;
                dfs(board, nr, nc, vis, trie, ls,set,  s + board[nr][nc]);
                vis[nr][nc] = false;
            }
        } 
    }
}