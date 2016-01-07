package edu.macalester.comp124.spellchecker;

/**
 * Interface for a dictionary containing words
 * Created by bjackson on 4/19/15.
 */
public interface WordDictionary {

    /**
     * Tests whether the word is in the dictionary.
     * @param word to test
     * @return true if word is in dictionary
     */
    public boolean hasWord(String word);


    /**
     * Adds a word to the dictionary
     * @param word to add
     */
    public void addWord(String word);


    /**
     * Returns a string containing a comma separated list of all the words contained in the dictionary
     * The words should be returned in sorted order.
     * @return Comma separated list of dictionary words.
     */
    public String getAllWordsSortedAlphabetically();

    /**
     * Returns the number of words stored in the dictionary
     * @return number of words
     */
    public int size();

}
