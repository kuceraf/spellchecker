package cz.fku.spelling;

import cz.fku.logic.dictionary.Dictionary;
import cz.fku.logic.dictionary.DictionaryBST;
import cz.fku.logic.dictionary.DictionaryLoader;
import cz.fku.logic.dictionary.DictionaryResource;
import cz.fku.logic.spelling.NearbyWords;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Filip on 09.10.2016.
 */
public class NearbyWordsTester {
    Dictionary smallDict;
    @Before
    public void setUp() throws Exception {
        smallDict = new DictionaryBST();

        smallDict.addWord("Hello");
        smallDict.addWord("HElLo");
        smallDict.addWord("help");
        smallDict.addWord("help");
        smallDict.addWord("a");
        smallDict.addWord("hol");
        smallDict.addWord("hell");
        smallDict.addWord("subsequent");
    }


    @Test
    public void testSubstitution() {
        List<String> currentList = new ArrayList<>();
        NearbyWords nearbyWords = new NearbyWords(smallDict);
        nearbyWords.substitution("hel",currentList,true);
    }

    @Test
    public void tetsSuggestions(){
        Dictionary d = new DictionaryBST();
        DictionaryLoader.loadDictionary(d, DictionaryResource.EN.resourcePath);
        NearbyWords w = new NearbyWords(d);

        List<String> result = w.suggestions("hel",2);
        System.out.println(result);
        assertTrue(result.size() == 2);
    }

    //Log run test
    @Test
    public void tetsSuggestions2(){
        Dictionary d = new DictionaryBST();
        DictionaryLoader.loadDictionary(d, DictionaryResource.EN.resourcePath);
        NearbyWords w = new NearbyWords(d);

        List<String> result = w.suggestions("kangaro",10);
        System.out.println(result);
        assertTrue(result.size() == 8);
    }

    @Test
    public void  testInsertions() {
        List<String> currentList = new ArrayList<>();
        NearbyWords nearbyWords = new NearbyWords(smallDict);
        nearbyWords.insertions("hel",currentList,false);
        assertEquals( 101, currentList.size());

        currentList = new ArrayList<>();
        nearbyWords.insertions("",currentList,false);
    }

    @Test
    public void  testDeletions() {
        List<String> currentList = new ArrayList<>();
        NearbyWords nearbyWords = new NearbyWords(smallDict);
        nearbyWords.deletions("hel",currentList,false);

        currentList = new ArrayList<>();
        nearbyWords.deletions("",currentList,false);
    }
}
