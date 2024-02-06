package SpellParser;

class Action {
  private String verb; 
  private int number; 
  private String descriptive_noun; 
  private String entity; 
  private static Action head; 
  static Action tail_mover; 
  Action next; 

  public Action(String verb, int number, String descriptive_noun, String entity) {
    this.verb = verb; 
    this.number = number; 
    this.descriptive_noun = descriptive_noun; 
    this.entity = entity; 
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
