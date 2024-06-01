package Arena_Container_Systems;

public abstract class Arena_Default_System implements Arena_Default, Arena_Default_Path_Map_Tracer {
  
/*java.util.Set
  java.util.SortedSet
  java.util.NavigableSet
  java.util.Queue
  java.util.concurrent.BlockingQueue
  java.util.concurrent.TransferQueue
  java.util.Deque
  java.util.concurrent.BlockingDeque*/

  // Take a round, halt after end of round using a block mechanism, random_no generation, data -> Number queue, Number queue -> Collection Queue, Dequeue the number -> collection (reduce queue-size)
  // Restore current round -> next round 
  // Measure a path from a linked list (start -> end) : Store data from path using a collection (random selection)

  void set_of_players() {
    System.out.println("set_of_players function definition"); 
  }
  
  void set_of_actions() {
    System.out.println("set_of_actions function definition"); 
  }

  void set_of_states() {
    System.out.println("set_of_states function definition");
  }

  void transition_function() {
    System.out.println("transition function definition");
  }

  void action_profile() {
    System.out.println("action profile function definition"); 
  }

  void set_of_decisions() {
    System.out.println("set_of_decisions function definition"); 
  }

  void partial_decision_set() {
    System.out.println("partial_decision_set function definition."); 
  }

}
