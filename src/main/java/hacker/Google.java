package hacker;

import java.util.HashMap;
import java.util.Map;

public class Google {
    static Map<String, Integer> words = new HashMap<>();

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static {

        words.put("apple",10);
        words.put("ab",8);
        words.put("c",2);
        words.put("b",5);
//        words.put("appa",11);
        words.put("app",5);
        words.put("appendix",4);
        words.put("boa",6);
        words.put("gob",5);

}
// expected output: ['app', 'app', 'boa', 'gob', 'apple']


//.  a->
    // p->
    // appa ->
    //

    // n - length of input string
    // O(n*(2^n))

    public static void main(String[] args) {
//        System.out.println(yourFunction("appappendixgoboagoboapple", words));
//        System.out.println(yourFunction("appb", words));
    }

    static int yourFunction(String s, Map<String,Integer> words){
        int score =0;
        int i=0;
        return internal(s,score,i, "");
    }
    // ab =10, ba=15
//. abcab
// send prefix blank
// ab
    static int internal(String s ,int score,int i, String prefix){
        int maxScore = score;
        int temp = 0;
        if(i>=s.length()){
            return score;
        }
        System.out.println(score+" "+i+" "+prefix);
        for(int k=i;k<s.length();k++){
            maxScore = score;
            char c = s.charAt(k);
            if(words.get(c+"")!=null){
                temp = words.get(c+"");
            }

            int s1 = internal(s,0,i+1,c+"") + temp;
            int s2 = internal(s,0,i+1,prefix+c) + (words.get(prefix+c)!=null? words.get(prefix+c):0);
            maxScore =  Math.max(maxScore,Math.max(s1,s2));
        }
        return maxScore;
    }
    /**
     * Q: Given two lists of elements A and B (can be anything strings, integers etc), compute the diff between them. Note that each of the lists can contain duplicates.
     * The diff should return two lists:
     *  - Unique elements in A that are not in B
     *  - Unique elements in B that are not in A
     *
     * For e.g.
     * Diff([1,1,2] [1]) = [1,2] and []
     * // 1 = 1
     * // 0 1
     * // 1,1,1, 2, 2, 0  [ 1,2]
     * // 1 ,0
     * // 2, 0
     * // 1, 1, 2, 0
     *
     * //  l1 = null || l2 = null
     * //  l1 = [1.....] , l2 =[] vice versa
     * //. no duplicates
     * //  no matching elements
     * //  l1 same elements , l2 distributed
     * //  l1 = l2 [] []
     * //  l1 few duplicates, l2 few duplicates with diff
     * //  l1,l2 duplicates with same freq
     * //  l1,l2 duplicates with diff freq
     * //  l1 (-MIN, +MAX) ,
     * //  l1 (-ve, +ve) , l2 (-ve, +v2) + 0
     * //  equals(), == l1 (new Integer()), l2(new Integer())
     *
     *
     * void <T> diffBwLists( T l1,T l2){
     *   List<> diff1 = new ArrayList();
     *     List<> diff2 = new ArrayList();
     *     getDIffLists(l1,l2,diff1,diff2);
     *     //print diff1 diff2
     * }
     *
     * void getDIffLists(List<T> l1, List<T> l2, List<T> diff1, List<T> diff2){
     *
     *   getDiffLists(l1, l2, diff1);
     *   getDiffLists(l2, l1, diff2);
     * }
     *
     * void getDiffLists(List<T> l1, List<T> l2, List<T> diff1){
     *   Map<T,Integer> l2Elems = new HashMap<>();
     *   for(T i: l2){
     *     if(!l2Elems.containKey(i)){
     *       l2Elems.put(i,0);
     *     }
     *     l2Elems.put(i,l2Elems.get(i)+1);
     *   }
     *    for(T i: l1){
     *       int freq = l2Elems.get(i);
     *       if(freq == null || freq == 0){
     *         diff1.add(i);
     *       }else{
     *         l2Elems.put(i,l2Elems.get(i)-1);
     *       }
     *    }
     * }
     *
     *
     * =====
     *
     * Find the Subsequence in a text which contains a, b, c, d in order -
     * Input: mmmmmmmmaple bacon donuts
     * Output: aple bacon d
     *
     * babcdaabbcd
     *  abcd             <- 4 characters long (the best)
     *      a b cd          6 chars long
     *       ab cd          5 chars long
     *  a     b cd          10 characters long
     *
     * //
     * // abcd
     * //
     * // babcaabbcd
     * // b ,a, ab, abc,
     *
     * char[] lettters = [a,b,c,d];
     * String out = "";
     *
     * for(int i=0;i<str.toCharArray();i++){
     *    char[] temp = letters;
     *    int k=0;
     *    char currentLetter = letter[k++];
     *    if(currentLetter = str.charAt(i)){
     *      currentLetter = letter[k];
     *      for(int j=i+1;str.toCharArray();i++){
     *        if(str.charAt(j) == currentLetter){
     *          currentLetter = letter[k++];
     *          if( k == ltteres.length()){
     *            localstr = from (i,j);
     *            str is not balnk && localStr< str
     *               out = str;
     *          }
     *        }
     *      }
     *    }
     * }
     */
}
