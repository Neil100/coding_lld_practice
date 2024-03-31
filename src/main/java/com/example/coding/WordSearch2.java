package com.example.coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordSearch2 {
    List<String> sol = new ArrayList<>();
    Set<String> ss = new HashSet<>();
    int m, n;
    boolean[][] passed;
    int[][] direction = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    public List<String> findWords(char[][] board, String[] words) {
        // trie structure for words
        m = board.length;
        n = board[0].length;

        Trie trie = new Trie();
        createTrieFromWords(trie, words);
        passed = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dfsOnBoard(i, j, board, trie);
            }
        }

        return ss.stream().collect(Collectors.toList());
    }

    private void dfsOnBoard(int i, int j, char[][] board, Trie trie) {
        // if(trie.isEndCharacter) {
        //     System.out.print(trie.word);
        //     ss.add(trie.word);
        // }

        char test = board[i][j];
        passed[i][j] = true;
        if(trie.characters[test-'a']!=null) {
            if(trie.characters[test-'a'].isEndCharacter)
                ss.add(trie.characters[test-'a'].word);
            int newI, newJ;
            for(int in=0; in<direction.length; in++) {
                newI = i+direction[in][0];
                newJ = j+direction[in][1];
                if(newI>=0 && newJ>=0 && newI<m && newJ<n && !passed[newI][newJ]) {
                    dfsOnBoard(newI, newJ, board, trie.characters[test-'a']);
                }
            }
        }
        passed[i][j] = false;
    }

    public void createTrieFromWords(Trie trie, String[] words) {

        for(int i=0; i<words.length; i++) {
            fillTrieFromWord(trie, words[i], 0);
        }
    }

    void fillTrieFromWord(Trie trie, String word, int index) {
        if(index>=word.length()) {
            trie.isEndCharacter = true;
            trie.word = word;
            return;
        }
        Trie newTrie;
        if(trie.characters[word.charAt(index)-'a'] == null) {
            newTrie = new Trie();
            trie.characters[word.charAt(index)-'a'] = newTrie;
        } else {
            newTrie = trie.characters[word.charAt(index)-'a'];
        }
        fillTrieFromWord(newTrie, word, index+1);
    }
}
