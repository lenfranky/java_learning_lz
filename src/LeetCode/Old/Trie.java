package LeetCode.Old;

import java.util.HashSet;
import java.util.Set;

import static LeetCode.Tools.print;

public class Trie {

    private Set<String> stringSet;
    private Set<String> preFixStringSet;
    /** Initialize your data structure here. */
    public Trie() {
        stringSet = new HashSet<>();
        preFixStringSet = new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        stringSet.add(word);
        for (int i = 1; i <= word.length(); i ++) {
            preFixStringSet.add(word.substring(0, i));
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return stringSet.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return preFixStringSet.contains(prefix);
    }

    public void showTrie() {
        System.out.println(stringSet);
        System.out.println(preFixStringSet);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.showTrie();
        print(trie.startsWith("app"));
    }
}
