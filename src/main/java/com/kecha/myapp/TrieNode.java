package com.kecha.myapp;


import java.util.HashMap;

public class TrieNode {
    /* Implementation of Node in Trie */

    private HashMap<Character, TrieNode> children;      //  access to next nodes by character as key
    private boolean isWord;      // identification of the word end

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setWord() {
        isWord = true;
    }

    public boolean getWord() {
        return isWord;
    }
}
