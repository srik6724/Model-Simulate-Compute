package Solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Course_Schedule {
  public boolean canFinish(int n, int[][] prerequisites) {
        // Creates a new list of arrays
        List<Integer>[] adj = new List[n];
        // indegree counter
        int[] indegree = new int[n];
        // ans list
        List<Integer> ans = new ArrayList<>();
        // 
        for (int[] pair : prerequisites) {
            int course = pair[0]; // 1
            int prerequisite = pair[1]; // 0
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);

            if (adj[current] != null) {
                for (int next : adj[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return ans.size() == n; 
}
}
