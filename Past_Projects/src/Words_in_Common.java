import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
/**
 * Given a String Array, each item starts with the name then message
 * Return the words(in message) used by all people in order of most used and alphabetic if tied
 */
public class Words_in_Common {

	public static ArrayList<String> Message_Board(String[] posts){

		Comparator<String> comp = new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				String [] s1 = o1.split(" ");
				String [] s2 = o2.split(" ");
				String word1 = s1[0];
				int freq1 = Integer.valueOf(s1[1]);
				String word2 = s2[0];
				int freq2 = Integer.valueOf(s2[1]);

				if(freq1==freq2) {
					return  word1.compareTo(word2);
				}
				else return freq2-freq1;
			}
		};
		TreeMap<String, String> tMap = new TreeMap<String, String>(comp);
		HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();
		HashMap<String, HashSet<String>> wordsToPerson = new HashMap<String, HashSet<String>>();
		HashSet<String> names = new HashSet<String>();
		for(String post: posts) {
			String [] content = post.split(" ");
			names.add(content[0]);
			for(int i=1; i<content.length;i++) {
				String word = content[i];
				if(wordFreq.containsKey(word)) {
					wordFreq.put(word, wordFreq.get(word)+1);
				}
				else {
					wordFreq.put(word,1);
				}
				if(wordsToPerson.containsKey(word)) {wordsToPerson.get(word).add(content[0]);}
				else {HashSet<String> temp_names = new HashSet<String>();
				temp_names.add(content[0]);
				wordsToPerson.put(word, temp_names);
				}
			}
		}

		wordsToPerson.forEach( (k,v) -> {if(v.size()==names.size()) {
			String s = k+ " " +wordFreq.get(k);
			tMap.put(s, k);
		}} );
		ArrayList<String> repeatedList = new ArrayList<String>(tMap.values());
		if(repeatedList.isEmpty()||wordsToPerson.isEmpty() || names.isEmpty() || wordFreq.isEmpty())return repeatedList;
		return repeatedList;
	}
}