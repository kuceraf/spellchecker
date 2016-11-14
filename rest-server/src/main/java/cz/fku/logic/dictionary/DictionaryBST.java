package cz.fku.logic.dictionary;

import org.springframework.stereotype.Component;

import java.util.TreeSet;

@Component
public class DictionaryBST implements Dictionary
{
   private TreeSet<String> dict;

	public DictionaryBST() {
        dict = new TreeSet<>();
        DictionaryLoader.loadDictionary(this, DictionaryResource.EN.resourcePath);
    }

    public boolean addWord(String word) {
        if(dict.contains(word.toLowerCase())) {
            return false;
        } else {
            dict.add(word.toLowerCase());
            return true;
        }
    }

    public int size()
    {
        return dict.size();
    }

    //FKU NOTE O(log(n)) in binary serarch tree implementation
    public boolean isWord(String s) {
        return dict.contains(s.toLowerCase());
    }

}
