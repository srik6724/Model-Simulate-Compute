package Arena_Systems_Build;

public abstract class Arena_Default_System implements Arena_Default, Arena_Default_Path_Map_Tracer {
  
/*java.util.Set
  java.util.SortedSet
  java.util.NavigableSet
  java.util.Queue
  java.util.concurrent.BlockingQueue (pick a number up)
  java.util.concurrent.TransferQueue (transfer data to another queue for processing)
  java.util.Deque
  java.util.concurrent.BlockingDeque*/ // (place the number from pick-up)

  // BlockingQueue
  // Take a round, halt after end of round using a block mechanism, random_no generation, data -> Number queue, Number queue -> Collection Queue, Dequeue the number -> collection (reduce queue-size)
  // Restore current round -> next round ()
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
