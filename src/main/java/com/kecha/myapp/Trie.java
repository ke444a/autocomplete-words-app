package com.kecha.myapp;
import java.util.*;

public class Trie {
    /* Trie Structure Implementation */

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (Character letter : word.toCharArray()) {
            if (!current.getChildren().containsKey(letter)) current.getChildren().put(letter, new TrieNode());
            current = current.getChildren().get(letter);
        }
        current.setWord();
    }

    public List<String> findByPrefix(String prefix) {
        prefix = prefix.trim().toLowerCase();
        if (prefix.isBlank()) {
            return new ArrayList<>();
        }

        List<String> autoCompleteWords = new ArrayList<String>();
        TrieNode current = root;

        for (Character symbol : prefix.toCharArray()) {
            if (!current.getChildren().containsKey(symbol)) {
                return autoCompleteWords;
            }
            current = current.getChildren().get(symbol);
        }
        searchList(current, prefix, autoCompleteWords);
        return autoCompleteWords;
    }

    public void searchList(TrieNode currentNode, String text, List<String> autoCompWords) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.getWord()) {
            autoCompWords.add(text);
        }

        for (Map.Entry<Character, TrieNode> mapElement : currentNode.getChildren().entrySet()) {
            searchList(currentNode.getChildren().get(mapElement.getKey()), text+mapElement.getKey(), autoCompWords);
        }
    }
}