package cz.fku.logic.spelling;

import java.util.Collection;

public interface ISpellingSuggest {

    /**
     * Suggest another word base on input word
     * @param word word to infer another words from
     * @param numSuggestions number of suggested word to return
     * @return collection of suggested words
     */
    Collection<String> suggestions(String word, int numSuggestions);
	
}
