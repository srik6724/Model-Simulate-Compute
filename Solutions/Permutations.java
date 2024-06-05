package Solutions;

import java.util.ArrayList;
import java.util.List;

class Permutations {

  public List<List<Integer>> permute(int[]nums) {
    List<List<Integer>> list = new ArrayList<>(); 
    backtrack(list, new ArrayList<Integer>(), nums); 
    return list; 
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums) {
    // Checks whether our tempList for storage = nums array length
    if(tempList.size() == nums.length) {
      list.add(new ArrayList<Integer>(tempList)); 
    } else {
      // Loops through the nums array
      for(int i = 0; i < nums.length; i++) {
        // Checks whether tempList contains the number extracted from nums array
        if(tempList.contains(nums[i])) {
          continue; 
        }
        tempList.add(nums[i]);
        backtrack(list, tempList, nums);
        tempList.remove(tempList.size()-1); 
      }
    }
  }

  public static void main(String[]args) {
    int[] tst = {1,2,3};
    
    List<List<Integer>> lsOfEachNumberOrdering = new Permutations().permute(tst); 

    for(List<Integer> ls: lsOfEachNumberOrdering) {
      System.out.println("List Here: " + ls); 
    }

  }


}
