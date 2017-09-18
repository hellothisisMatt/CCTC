import java.util.HashMap;
import java.util.Map;

/**
 * Solution to solving unique characters in a string problem using a hash map.
 * - Matthew Gopez
 */

public class uniqueCharsInString {
    public static void main(String[] args){
        String testString = "GGAAGGACCCTTWEEEEAFFFCCAA";
        Map frequencyMap = findCharFrequencies(testString);
        printHashMap(frequencyMap);
        printUniqueStrings(frequencyMap);
    }

    private static Map<Character, Integer> findCharFrequencies(String s){
        Map<Character, Integer> freqMap = null;
        if(s != null && s.length() > 0){
            freqMap = new HashMap<Character, Integer>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(freqMap.get(c) != null){
                    freqMap.put(c, freqMap.get(c)+1);
                }else{
                    freqMap.putIfAbsent(c,0);
                }
            }
        }else{
            System.err.println("No string was provided");
        }
        return freqMap;
    }

    private static void printHashMap(Map<Character, Integer> hm){
        System.out.println("\nPrinting out character frequencies");
        if(hm != null && hm.size() > 0 ) {
            for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                System.out.println("Character : [" + entry.getKey() + "]\t"+
                        "Value : [" + entry.getValue() + "]");
            }
        }else{
            System.err.println("Received an empty hashmap!");
        }
    }

    private static void printUniqueStrings(Map<Character, Integer> hm){
        if(hm != null && hm.size() > 0){
            System.out.println("\nPrinting Unique Characters");
            for(Map.Entry<Character, Integer> entry : hm.entrySet()){
                if(entry.getValue().equals(1)){
                    System.out.println("Character : [" + entry.getKey() + "]\t"+
                            "Value : [" + entry.getValue() + "]");
                }
            }
        }else{
            System.err.println("Received an empty hashmap!");
        }
    }

}
