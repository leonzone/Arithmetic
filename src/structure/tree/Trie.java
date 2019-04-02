package structure.tree;

/**
 * Author: reiserx
 * Date:2019/1/18
 * Des:Trie 树
 */
public class Trie {

    private TrieNode root = new TrieNode('/');


    public void insert(char[] text) {
        TrieNode node = root;
        for (int i = 0; i < text.length; i++) {
            char value = text[i];
            int index = value - 'a';
            if (node.childen[index] == null) {
                node.childen[index] = new TrieNode(value);
            }
            node = node.childen[index];
        }
        node.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode node = root;
        for (int i = 0; i < pattern.length; i++) {
            char value = pattern[i];
            int index = value - 'a';
            if (node.childen[index] == null) {
                return false;
            }
            node = node.childen[index];
        }

        if (!node.isEndingChar) {
            return false;
        }
        return true;
    }


    public class TrieNode {
        public char data;
        public TrieNode[] childen = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello".toCharArray());
        trie.insert("her".toCharArray());
        trie.insert("hi".toCharArray());
        trie.insert("how".toCharArray());

        System.out.println(trie.find("hi".toCharArray()));
        System.out.println(trie.find("he".toCharArray()));
        System.out.println(trie.find("good".toCharArray()));
    }
}
