package structure.tree;

/**
 * Author: reiserx
 * Date:2019/1/18
 * Des:Trie 树
 */
public class Trie {

    private TrieNode root = new TrieNode('/');


    public void insert(char[] text) {
        //todo
    }

    public boolean find(char[] pattern) {
        //todo
        return false;
    }


    public class TrieNode {
        public char data;
        public TrieNode[] childen = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
