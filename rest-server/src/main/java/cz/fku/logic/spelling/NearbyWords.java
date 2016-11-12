package cz.fku.logic.spelling;

import cz.fku.logic.dictionary.Dictionary;

import java.util.*;

public class NearbyWords implements ISpellingSuggest, IWordModification {
	// THRESHOLD to determine how many words to look through when looking
	// for spelling suggestions (stops prohibitively long searching)
	private static final int THRESHOLD = 1000; 

	private Dictionary dict;

	public NearbyWords(Dictionary dict)
	{
		this.dict = dict;
	}

	@Override
	public List<String> distanceOne(String s, boolean wordsOnly )  {
		   List<String> retList = new ArrayList<String>();
		   insertions(s, retList, wordsOnly);
		   substitution(s, retList, wordsOnly);
		   deletions(s, retList, wordsOnly);
		   return retList;
	}

	@Override
	public void substitution(String s, List<String> currentList, boolean wordsOnly) {
		// for each letter in the s and for all possible replacement characters
		for(int index = 0; index < s.length(); index++){
			for(int charCode = (int)'a'; charCode <= (int)'z'; charCode++) {
				// use StringBuffer for an easy interface to permuting the
				// letters in the String
				StringBuffer sb = new StringBuffer(s);
				sb.setCharAt(index, (char)charCode);

				// if the item isn't in the list, isn't the original string, and
				// (if wordsOnly is true) is a real word, add to the list
				if(!currentList.contains(sb.toString()) &&
						(!wordsOnly||dict.isWord(sb.toString())) &&
						!s.equals(sb.toString())) {
					currentList.add(sb.toString());
				}
			}
		}
	}

	@Override
	public void insertions(String s, List<String> currentList, boolean wordsOnly ) {
		// for each letter in the s and for all possible replacement characters
		for(int index = 0; index <= s.length(); index++){
			for(int charCode = (int)'a'; charCode <= (int)'z'; charCode++) {
				// use StringBuffer for an easy interface to permuting the
				// letters in the String
				StringBuffer sb = new StringBuffer(s);
				sb.insert(index, (char)charCode);
				//sb.setCharAt(index, (char)charCode);
				// if the item isn't in the list, isn't the original string, and
				// (if wordsOnly is true) is a real word, add to the list
				if(!currentList.contains(sb.toString()) &&
						(!wordsOnly||dict.isWord(sb.toString())) &&
						!s.equals(sb.toString())) {
					currentList.add(sb.toString());
				}
			}
		}
	}

	@Override
	public void deletions(String s, List<String> currentList, boolean wordsOnly ) {
		for(int index = 0; index < s.length(); index++){
			StringBuffer sb = new StringBuffer(s);
			sb.deleteCharAt(index);
			if(!currentList.contains(sb.toString()) &&
					(!wordsOnly||dict.isWord(sb.toString())) &&
					!s.equals(sb.toString())) {
				currentList.add(sb.toString());
			}
		}
	}

	@Override
	public List<String> suggestions(String word, int numSuggestions) {

		// initial variables
		Queue<String> queue = new LinkedList<String>();     // String to explore
		HashSet<String> visited = new HashSet<String>();   // to avoid exploring the same
														   // string multiple times
		List<String> retList = new LinkedList<String>();   // words to return

		// insert first node
		queue.add(word);
		visited.add(word);

		String curr;
		int itNum = 0;
		while(!queue.isEmpty()) {
			curr = queue.remove();
			List<String> neighbors = distanceOne(curr, false);
			for(String neighbor : neighbors) {
				if(!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
					if(dict.isWord(neighbor)){
						retList.add(neighbor);
					}
				}
				if(numSuggestions == retList.size()){
					return retList;
				}
				itNum++;
			}
		}

		return retList;

	}

	//TODO dat do testu
//   public static void main(String[] args) {
//	   //basic testing code to get started
//	   String word = "i";
//	   // Pass NearbyWords any Dictionary implementation you prefer
//	   Dictionary d = new DictionaryHashSet();
//	   DictionaryLoader.loadDictionary(d, "data/dict.txt");
//	   NearbyWords w = new NearbyWords(d);
//	   List<String> l = w.distanceOne(word, true);
//	   System.out.println("One away word Strings for for \""+word+"\" are:");
//	   System.out.println(l+"\n");
//
//	   word = "tailo";
//	   List<String> suggest = w.suggestions(word, 10);
//	   System.out.println("Spelling Suggestions for \""+word+"\" are:");
//	   System.out.println(suggest);
//
//   }

}
