package Object_Types_Parser;

class Action {
  private String verb; 
  private int number; 
  private String entity; 
  private String descriptive_noun; 
  private static Action head; 
  static Action tail_mover; 
  Action next; 

  void curr_info() {
    System.out.println("#####################################"); 
    System.out.println("Displaying current action information."); 
    System.out.println("Action Verb: " + this.verb);
    System.out.println("Action Number: " + this.number); 
    System.out.println("Action Descriptive Noun:" + this.descriptive_noun); 
    System.out.println("Action Entity: " + this.entity); 
    System.out.println("#####################################"); 
  }

  public Action(String verb, int number, String descriptive_noun, String entity) {
    this.verb = verb; 
    this.number = number; 
    this.entity = entity; 
    this.descriptive_noun = descriptive_noun; 
    next = null; 
  }

  public String get_verb() 
  {
    return this.verb; 
  }

  public int get_number() 
  {
    return this.number; 
  }

  public String get_descriptive_noun() 
  {
    return this.descriptive_noun; 
  }

  public String get_entity() 
  {
    return this.entity; 
  }

  public Action get_head() 
  {
    return Action.head; 
  }

  public void set_next_action(Action action)
  {
    if(Action.head == null) {
      head.next = action; 
      tail_mover = head; 
    }
    else {
      tail_mover.next = action; 
      tail_mover = tail_mover.next;
    }
  }

}
