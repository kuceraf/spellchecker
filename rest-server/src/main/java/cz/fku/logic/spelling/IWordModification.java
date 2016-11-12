package cz.fku.logic.spelling;

import java.util.List;

/**
 * Created by Filip on 12.11.2016.
 */
public interface IWordModification {
    /** Add to the currentList Strings that are one character mutation away
     * from the input string.
     * @param s The original String
     * @param currentList is the list of words to append modified words
     * @param wordsOnly controls whether to return only words or any String
     */
    void substitution(String s, List<String> currentList, boolean wordsOnly);

    /** Add to the currentList Strings that are one character insertion away
     * from the input string.
     * @param s The original String
     * @param currentList is the list of words to append modified words
     * @param wordsOnly controls whether to return only words or any String
     */
    void insertions(String s, List<String> currentList, boolean wordsOnly);

    /** Add to the currentList Strings that are one character deletion away
     * from the input string.
     * @param s The original String
     * @param currentList is the list of words to append modified words
     * @param wordsOnly controls whether to return only words or any String
     */
    void deletions(String s, List<String> currentList, boolean wordsOnly );

    /** Return the list of Strings that are one modification away
     * from the input string.
     * @param s The original String
     * @param wordsOnly controls whether to return only words or any String
     * @return list of Strings which are nearby the original string
     */
    List<String> distanceOne(String s, boolean wordsOnly );
}
