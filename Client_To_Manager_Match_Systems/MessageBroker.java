package Client_To_Manager_Match_Systems;

import java.util.HashMap;
import java.util.Map;
/*
 * Class Highlights: 
 *  1. Attributes
 *      - count: static int
 *      - executeOnce: static boolean
 *      - components: static Map<Integer, Component>
 *  2. Operational Methods
 *      - add_component(component: Component): static void - Updates count of component, places component inside Map
 *      - loopThroughFullMapOrderingOfComponents(): static void - Returns empty if map size 0, else loop through map and display component information
 *      - getFullMapOrderingOfComponents(): static Map<Integer, Component> - Initializes HashMap for first iteration if component list empty, else returns component list
 */
class MessageBroker {
  private static int count = 0; 
  private static boolean executeOnce = false;
  private static Map<Integer, Component> components; 

  static void add_component(Component component) {
    components.put(++MessageBroker.count, component); 
  }

  static void loopThroughFullMapOrderingOfComponents() {
    if(MessageBroker.components.size() == 0) {
      System.out.println("Empty Map with no components."); 
    }
    else {
      for(Integer id: components.keySet()) {
        System.out.println("--------------------------------------------------------");
        System.out.println("Id of Integer: " + id);
        System.out.println("Publisher Name: " + components.get(id).getPublisherName()); 
        System.out.println("Subscriber Name: " + components.get(id).getSubscriberName());
        System.out.println("Looping through list of events"); 
        for(Event event: components.get(id).getListOfEvents()) {
          System.out.println("Event Type: " + event.getType()); 
          System.out.println("Event Information: " + event.getInformation());
        }
        System.out.println("----------------------------------------------------------"); 
      }
    }
  }

  static Map<Integer, Component> getFullMapOrderingOfComponents() {
    if(MessageBroker.executeOnce == false) {
      components = new HashMap<Integer, Component>(); 
      MessageBroker.executeOnce = true;
    }
    return MessageBroker.components;
  }
}
