package Graphs;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStates {

  private static int callsToDfs = 0; 

  public List<Integer> eventualSafeNodes(int[][] graph) throws InterruptedException {
      List<Integer> eventualSafe = new ArrayList<>();
      int n = graph.length;
      int[] color = new int[n]; // 0: unvisited, 1: visiting, 2: visited and safe

      for (int i = 0; i < n; i++) {
          System.out.println("Executed");
          if (dfs(i, graph, color)) {
              eventualSafe.add(i);
              System.out.println("Added safe node " + i); 
          }
      }
      
      return eventualSafe;
  }

  private boolean dfs(int node, int[][] graph, int[] color) throws InterruptedException {

      if (color[node] != 0) {
          return color[node] == 2;
      }

      color[node] = 1; // Mark as visiting

      for (int neighbor : graph[node]) {
          if (!dfs(neighbor, graph, color)) {
              return false;
          }
      }

      color[node] = 2; // Mark as visited and safe
      
      return true;
  }

  private void traceDFSCalls() {
    System.out.println("Starting the process for tracing the DFS calls"); 


  }

  public static void main(String[]args) throws InterruptedException {
    EventualSafeStates ess = new EventualSafeStates(); 
    int[][] graph = {
      {1,2}, 
      {2,3},
      {5},
      {0},  
      {},
      {}
    }; 
    List<Integer> eventualSafe = ess.eventualSafeNodes(graph); 
    System.out.println("Eventual safe nodes: " + eventualSafe); 
  }

}
