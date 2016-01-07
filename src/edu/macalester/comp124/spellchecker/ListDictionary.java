package edu.macalester.comp124.spellchecker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rmunsil on 12/3/15.
 */
public class ListDictionary implements WordDictionary {

    private ArrayList<String> words;

    public ListDictionary() {
        words = new ArrayList<String>();
    }

    /**
     * Tests whether the word is in the dictionary.
     *
     * @param word to test
     * @return true if word is in dictionary
     */
    @Override
    public boolean hasWord(String word) {
        return words.contains(word);
    }

    /**
     * Adds a word to the dictionary
     *
     * @param word to add
     */
    @Override
    public void addWord(String word) {
        words.add(word);
    }

    /**
     * Returns a string containing a comma separated list of all the words contained in the dictionary
     * The words should be returned in sorted order.
     *
     * @return Comma separated list of dictionary words.
     */
    @Override
    public String getAllWordsSortedAlphabetically() {
        Collections.sort(words);

        StringBuilder sb = new StringBuilder();
        for(String word : words) {
            sb.append(word + ", ");
        }
        //Delete last comma and space
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /**
     * Returns the number of words stored in the dictionary
     *
     * @return number of words
     */
    @Override
    public int size() {
        return words.size();
    }
}