package hacker;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string input and a string str. 
 * Find out the number of indices(i) in input such that the string str
 * can be formed by shuffling the characters from the left and right of i.
 * 
 * @author fahad
 *
 */
public class StringOc {

    public static void main(String[] args) {		
		System.out.println(findCount("xprogxrmaxemrppropgxrmaxemr", "programmer"));
	}
    
    public static int findCount(String input,String str) {
    	int count = 0;
    	if(input.length()>str.length()){
    		Map<Character, Integer> characterMap =  getCharacterMap(0, str.length(), str);
        	for(int i=str.length();i<input.length();i++){
        		boolean presentInLeft = doesContains(0,i,input,characterMap);
        		if(presentInLeft) {
        			boolean presentInRight = doesContains(i+1,input.length(),input,characterMap);
        			if(presentInRight) {
        				count++;
        			}
        		}
        	}
    	}
    	return count;
    }

	private static boolean doesContains(int start, int end, String str, Map<Character, Integer> characterMap) {
		Map<Character, Integer> inputCharacterMap = getCharacterMap(start, end, str);
		System.out.print("");
		for(Character c : characterMap.keySet()) {
			if(inputCharacterMap.get(c) == null || characterMap.get(c) > inputCharacterMap.get(c)) {
				return false;
			}
		}
		return true;
	}

	private static Map<Character, Integer> getCharacterMap(int start, int end, String str) {
		Map<Character, Integer> inputCharacterMap = new HashMap<Character, Integer>();
		for(int i=start;i<end;i++) {
			Character c = str.charAt(i);
    		if(!inputCharacterMap.containsKey(c)) {
    			inputCharacterMap.put(c, 0);
    		}
    		inputCharacterMap.put(c, inputCharacterMap.get(c)+1);
		}
		return inputCharacterMap;
	}

}
