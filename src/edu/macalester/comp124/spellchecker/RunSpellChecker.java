package edu.macalester.comp124.spellchecker;

/**
 * Created by bjackson on 4/19/15.
 */
public class RunSpellChecker {
    public static void main(String[] args){
        int maxMultiplier = 5;

        for(int i=0; i < maxMultiplier; i++) {
            String dictionaryFile = "124-spellchecker/words.txt";

            System.out.println("**** Tree ****");
            SpellChecker treeChecker = new SpellChecker("tree", dictionaryFile, i);
            treeChecker.checkSpelling(args[0]);

            System.out.println("**** List ****");
            SpellChecker listChecker = new SpellChecker("list", dictionaryFile, i);
            listChecker.checkSpelling(args[0]);


            System.out.println("**** HashMap ****");
            SpellChecker hashMapChecker = new SpellChecker("hashMap", dictionaryFile, i);
            hashMapChecker.checkSpelling(args[0]);

            System.out.println("=======================================================");
        }
    }
}