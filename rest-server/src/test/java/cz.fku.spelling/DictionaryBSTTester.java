package cz.fku.spelling;

import cz.fku.logic.dictionary.Dictionary;
import cz.fku.logic.dictionary.DictionaryBST;
import cz.fku.logic.dictionary.DictionaryLoader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Filip on 12.11.2016.
 */
public class DictionaryBSTTester {
    private static final String DICTIONARY_FILE = "dictionary/EN_dict_small.txt";

    Dictionary emptyDict;
    Dictionary smallDict;
    Dictionary largeDict;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        emptyDict = new DictionaryBST();
        smallDict = new DictionaryBST();
        largeDict = new DictionaryBST();

        smallDict.addWord("Hello");
        smallDict.addWord("HElLo");
        smallDict.addWord("help");
        smallDict.addWord("a");
        smallDict.addWord("subsequent");

        DictionaryLoader.loadDictionary(largeDict, DICTIONARY_FILE);
    }

    @Test
    public void testSize()
    {
        assertEquals("Testing size for empty dict", 0, emptyDict.size());
        assertEquals("Testing size for small dict", 4, smallDict.size());
        assertEquals("Testing size for large dict", 4438, largeDict.size());
    }
}
