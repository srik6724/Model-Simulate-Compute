package Solutions;

import java.util.HashMap;
import java.util.List;

class Brick_Wall {
  public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edge_frequency = new HashMap<>(); 
        int max_frequency = 0; 

        for(int row = 0; row < wall.size(); row++) {
            int edge_position = 0; // Variable to store different edge positions

            for(int brick_no = 0; brick_no < wall.get(row).size()-1; brick_no++) {
                int current_brick_length = wall.get(row).get(brick_no); // 3
                edge_position = edge_position + current_brick_length; // 3
                edge_frequency.put(edge_position, edge_frequency.getOrDefault(edge_position, 0) + 1); // 2
                max_frequency = Math.max(edge_frequency.get(edge_position), max_frequency); // 2, 1
            }
        }
        return wall.size() - max_frequency; 
    }
}
