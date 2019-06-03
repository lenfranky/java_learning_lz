package LeetCode;

import static LeetCode.Tools.print;

public class Trie {
    class TrieNode {
        boolean isword;
        TrieNode[] nextNodeArray = new TrieNode[26];
    }

    TrieNode rootNode;

    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currNode = rootNode;
        int currIndex;
        for (char ch: word.toCharArray()) {
            currIndex = ch - 'a';
            if (currNode.nextNodeArray[currIndex] == null) {
                currNode.nextNodeArray[currIndex] = new TrieNode();
            }
            currNode = currNode.nextNodeArray[currIndex];
        }
        currNode.isword = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currNode = rootNode;
        int currIndex;
        for (char ch: word.toCharArray()) {
            currIndex = ch - 'a';
            currNode = currNode.nextNodeArray[currIndex];
            if (currNode == null) return false;
        }
        return currNode.isword;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currNode = rootNode;
        int currIndex;
        for (char ch: prefix.toCharArray()) {
            currIndex = ch - 'a';
            currNode = currNode.nextNodeArray[currIndex];
            if (currNode == null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
//        trie.showTrie();
        print(trie.startsWith("app"));
        print(trie.search("app"));
    }
}
