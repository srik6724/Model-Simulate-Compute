package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Sort_Characters_By_Frequency {
  public String frequencySort(String s) {
        // Use a map to put in the frequency of each character

        // Sort it by decreasing order with a max-heap, where the character
        // with the highest frequencies appears at the top
        
        // Then concatenate the string by following the max-heap level order traversal 
        
        Map<Character, Integer> freqMap = new HashMap<>(); 
        for(char c: s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1); 
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        ); 

        maxHeap.addAll(freqMap.entrySet()); 

        StringBuilder result = new StringBuilder(); 
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll(); 
            char c = entry.getKey(); 
            int freq = entry.getValue(); 
            for(int i = 0; i < freq; i++) {
                result.append(c); 
            }
        }

        return result.toString(); 
    }
}
