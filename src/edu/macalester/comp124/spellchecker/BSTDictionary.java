package edu.macalester.comp124.spellchecker;

import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * Created by lucasgagnon on 12/3/15.
 */
public class BSTDictionary implements WordDictionary {

    private TreeMap<String, String> dictionary;

    public BSTDictionary() { dictionary = new TreeMap<String, String>();}

    @Override
    public boolean hasWord(String word) {
        return dictionary.containsKey(word);
    }

    @Override
    public void addWord(String word) {
        dictionary.put(word, null);
    }

    @Override
    public String getAllWordsSortedAlphabetically() {
        NavigableSet<String> sortedWords = dictionary.descendingKeySet();

        StringBuilder sb = new StringBuilder();
        for(String word : sortedWords) {
            sb.append(word + ", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    @Override
    public int size() {
        return dictionary.size();
    }
}