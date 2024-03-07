package com.example.coding;

public class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie iterator = root;
        for(int i=0; i<word.length(); i++) {
            if(iterator.characters[word.charAt(i)-'a'] == null) {
                iterator.characters[word.charAt(i)-'a'] = new Trie();
            }
            iterator = iterator.characters[word.charAt(i)-'a'];
        }
        iterator.isEndCharacter = true;
    }

    public boolean search(String word) {
        return dfsForWord(word, root, 0);
    }

    boolean dfsForWord(String word, Trie root, int index) {
        if(index>=word.length()) {
            return root.isEndCharacter;
        }

        if(word.charAt(index)=='.') {
            for(int i=0; i<root.characters.length; i++) {
                if(dfsForWord(word, root.characters[i], index+1)) {
                    return true;
                }
            }
            return false;
        } else {
            if(root.characters[word.charAt(index)-'a']==null)
                return false;
            else {
                return dfsForWord(word, root.characters[word.charAt(index)-'a'], index+1);
            }
        }
    }
}
