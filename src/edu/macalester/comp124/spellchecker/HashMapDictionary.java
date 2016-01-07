package edu.macalester.comp124.spellchecker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by bjackson on 4/19/15.
 */
public class HashMapDictionary implements WordDictionary {

    private HashMap<String, String> dictionary;

    /**
     * Create a hashmap to store the dictionary words
     */
    public HashMapDictionary(){
        dictionary = new HashMap<String, String>();
    }

    /**
     * Adds word to the dictionary
     * @param word to add
     */
    public void addWord(String word){
        dictionary.put(word, null); //We only care about the keys so the values can just be null.
    }

    /**
     * Returns true if word is in the hashmap dictionary
     * @param word to test
     * @return
     */
    public boolean hasWord(String word){
        return dictionary.containsKey(word);
    }

    /**
     * Returns a string containing a comma separated list of words alphabetically sorted.
     * @return
     */
    public String getAllWordsSortedAlphabetically(){
        Object[] keys = dictionary.keySet().toArray();
        Arrays.sort(keys); // Hashmap does not guarantee that keys are sorted

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < keys.length; i++) {
            builder.append((String) keys[i]);
            if(i < keys.length - 1){
                builder.append(",");
            }
        }
        return builder.toString();
    }

    /**
     * Returns the size of the dictionary
     * @return number of words
     */
    public int size(){
        return dictionary.size();
    }
}
