package com.kecha.myapp;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class AutocompleteProgram  {
    /* Initializing Trie & Filling it in with words from file */

    private Trie prefixTree;      

    private void createTree() {
        /* Filling in the prefix tree during the construction of AutocompleteProgram object */
        try {
            prefixTree = new Trie();
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/dict.txt"));
            String currentLine;
            while ((currentLine = in.readLine()) != null) {
                prefixTree.insert(currentLine);
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public AutocompleteProgram() {
        createTree();
    }

    public List<String> displaySearchResult(String input) {
       return prefixTree.findByPrefix(input);
    }

    public static void main(String[] args) {
        new AutocompleteGUI().requestFocusInWindow();
    }
}

