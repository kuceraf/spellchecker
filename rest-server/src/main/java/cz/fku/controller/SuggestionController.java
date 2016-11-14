package cz.fku.controller;

import cz.fku.logic.spelling.ISpellingSuggest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Filip on 14.11.2016.
 */
@RestController
@RequestMapping("/suggestion")
public class SuggestionController {

    @Autowired
    ISpellingSuggest nearbyWords;

    private static final int SUGGESTION_NUMBER = 6;

    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public Collection<String> test(@PathVariable String word) {
      Collection<String> suggestions = nearbyWords.suggestions(word,SUGGESTION_NUMBER);
        return suggestions;
    }
}
