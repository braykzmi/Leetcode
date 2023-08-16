import java.util.ArrayList;
import java.util.List;

class TrieNode {
    private TrieNode[] children;
    private String word;

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result, visited);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.getChildren()[index] == null) {
                    node.getChildren()[index] = new TrieNode();
                }
                node = node.getChildren()[index];
            }
            node.setWord(word);
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }

        char c = board[i][j];
        int index = c - 'a';
        if (node.getChildren()[index] == null) {
            return;
        }

        node = node.getChildren()[index];
        if (node.getWord() != null) {
            result.add(node.getWord());
            node.setWord(null); 
        }

        visited[i][j] = true;
        dfs(board, i - 1, j, node, result, visited); // Up
        dfs(board, i + 1, j, node, result, visited); // Down
        dfs(board, i, j - 1, node, result, visited); // Left
        dfs(board, i, j + 1, node, result, visited); // Right
        visited[i][j] = false;
    }
}
