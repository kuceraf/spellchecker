package cz.fku.logic.dictionary;

/**
 * Created by Filip on 13.11.2016.
 */
public enum DictionaryResource {
    EN("dictionary/EN_dict.txt"),
    EN_SMALL("dictionary/EN_dict_small.txt");

    public String resourcePath;
    DictionaryResource(String resource) {
        this.resourcePath = resource;
    }
}
