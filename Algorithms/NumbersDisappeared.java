package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NumbersDisappeared {
  public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> hs = new HashSet<>();

        for(int val:nums)
            hs.add(val);
        
        List<Integer> notExistingValues = new ArrayList<Integer>(); 
        for(int i = 1; i <= nums.length; i++) {
            if(hs.contains(i)) {
                continue; 
            }
            else {
                notExistingValues.add(i); 
            }
        }
        return notExistingValues;
    }
}
