package edu.macalester.comp124.spellchecker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by bjackson on 4/19/15.
 */
public class SpellChecker {

    // The dictionary object we are using to look up words.
    private WordDictionary dictionary;

    /**
     * Constructor to create a specific instance of a spell checker.
     * @param dictionaryType The type of dictionary to use. Possible values are "tree", "list", and "hashMap".
     * @param dictionaryFile Path to the text file containing the dictionary words
     * @param multiplier Used to multiply the number of words in the dictionary. A multiplier of 1 will create a dictionary using only the words found in dictionaryFile
     */
    public SpellChecker(String dictionaryType, String dictionaryFile, int multiplier){
        if(dictionaryType.equals("tree")){
            dictionary = new BSTDictionary();
        }
        else if(dictionaryType.equals("list")){
            dictionary = new ListDictionary();

        }
        else if(dictionaryType.equals("hashMap")){
            dictionary = new HashMapDictionary();
        }
        else {
            System.err.println("dictionaryType must be either \"tree\", \"list\", or \"hashMap\"");
            System.exit(-1);
        }

        System.out.print("Loading Dictionary ... ");
        loadDictionary(dictionaryFile, multiplier);

        long startTime = System.currentTimeMillis();
        String sortedWords = dictionary.getAllWordsSortedAlphabetically();
        long endTime = System.currentTimeMillis();
        System.out.format("Total time to get sorted string of dictionary words: %d ms\n", endTime - startTime);
    }


    /**
     * Loads in a text file from the path fileNameToCheck. Check each word in the file to see whether it is contained in
     * the dictionary.
     * @param fileNameToCheck Path to a text file that should be spellchecked.
     */
    public void checkSpelling(String fileNameToCheck){

        ArrayList<String> words = readFile(fileNameToCheck);
        TreeMap<String, Object> misspelledWords = new TreeMap<String, Object>();

        long startTime = System.currentTimeMillis();

        //Check whether each word in the words ArrayList is in the dictionary. Keep track of misspelled words
        for(String word : words) {
            if(!dictionary.hasWord(word)) {
                misspelledWords.put(word, null);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.format("Total time to check for misspelled words: %d ms\n", endTime - startTime);

        //Print the misspelled words in alphabetical order.
//        NavigableSet<String> sortedWords = misspelledWords.descendingKeySet();
//
//        StringBuilder sb = new StringBuilder();
//        for(String word : sortedWords) {
//            sb.append(word + "\r\n");
//        }
//        System.out.println("Misspelled words:\r\n" + sb.toString());
    }

    /**
     * Loads the dictionary file and adds the words to the dictionary. The multiplier will multiply the number of words
     * found in dictionaryFile to make n larger.
     * @param dictionaryFile File containing dictionary words
     * @param multiplier
     */
    private void loadDictionary(String dictionaryFile, int multiplier){
        ArrayList<String> words = readFile(dictionaryFile);

        //Randomize the words so they aren't in alphabetical order when we read them in
        Collections.shuffle(words);

        for(String word : words){
            dictionary.addWord(word);
        }

        // To try different sizes of dictionaries, we add new words by appending a number to each word. e.g. if the word was "the" we would add "the001", etc.
        if (multiplier > 1){
            for(int i=1; i < multiplier; i++){
                for(String word : words){
                    String newWord = word+String.format("%03d", i);
                    dictionary.addWord(newWord);
                }
            }
        }

        System.out.println("Number of words: "+dictionary.size());
    }

    /**
     * Read in a text file using a scanner object.
     * @param fileName File to read
     * @return ArrayList of individual words from the file ignoring whitespace and punctuation.
     */
    private ArrayList<String> readFile(String fileName){
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException ioex) {
            System.err.println("Error reading file "+fileName);
            ioex.printStackTrace();
            System.exit(-1);
        }

        ArrayList<String> words = new ArrayList<String>();

        //Split based on punctuation and whitespace.
        scan.useDelimiter("[\\p{Punct}\\s]+");
        while(scan.hasNext()){
            String token = scan.next();
            token = token.toLowerCase(); //Make everything lowercase so we get fewer misspellings.
            words.add(token);
        }

        return words;
    }



}