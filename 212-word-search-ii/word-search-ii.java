class Node {
    Node[] links = new Node[26];
    boolean isEnd = false;
    String word = null; // Store full word at terminal node for fast retrieval
}

class Trie {
    Node root = new Node();

    void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.links[idx] == null) {
                node.links[idx] = new Node();
            }
            node = node.links[idx];
        }
        node.isEnd = true;
        node.word = word;
    }
}

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> result = new HashSet<>();
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, Node node, Set<String> result) {
        char ch = board[i][j];

        if (ch == '#' || node.links[ch - 'a'] == null) return;

        node = node.links[ch - 'a'];

        if (node.isEnd) {
            result.add(node.word);
            node.isEnd = false;
        }

        board[i][j] = '#'; // Mark visited

        for (int dir = 0; dir < 4; dir++) {
            int ni = i + dx[dir];
            int nj = j + dy[dir];

            if (ni >= 0 && nj >= 0 && ni < board.length && nj < board[0].length) {
                dfs(board, ni, nj, node, result);
            }
        }

        board[i][j] = ch; // Unmark
    }
}
