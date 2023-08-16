class WordDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(word.toCharArray(), 0, root);
    }

    private boolean searchWord(char[] word, int index, TrieNode node) {
        if (index == word.length) {
            return node.isWord;
        }

        char c = word[index];
        if (c != '.') {
            TrieNode child = node.children[c - 'a'];
            if (child == null) {
                return false;
            }
            return searchWord(word, index + 1, child);
        } else {
            for (TrieNode child : node.children) {
                if (child != null && searchWord(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}
