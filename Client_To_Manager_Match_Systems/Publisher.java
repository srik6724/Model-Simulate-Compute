package Client_To_Manager_Match_Systems;

import java.util.Arrays;
import java.util.List;
/*
 * Class Highlights
 * 1. Attributes
 *    - name: String
 *    - types: List<String>
 * 2. Constructor
 *    - Publisher() - Empty constructor
 *    - Publisher(name: String, types: List<String>) - Initializes attributes name: String, types: List<String>
 * 3. Getter Methods
 *    - getName(): String - Returns publisher name
 *    - getTypes(): List<String> - Returns the information about the event
 * 4. Operational Methods
 *    - publish_event(event: Event): void - Publishes meal plan -> Create Event Notification
 */
class Publisher {
  private String name; 
  private List<String> types; 

  Publisher() {

  }

  Publisher(String name, List<String> types) {
    this.name = name; 
    this.types = types; 
  }

  String getName() {
    return name; 
  }

  List<String> getTypes() {
    return types; 
  }

  void publish_event(Event event) {
    // Publish meal-plan -> start execution
    try {
      if(event.getType().equals("publish")) {
        System.out.println("-------------------------------------------------"); 
        System.out.println("Publisher Name: " + event.getInformation().get(0));
        System.out.println("Type of Plan: " + event.getInformation().get(1)); 
        System.out.println("Food Name: " + event.getInformation().get(2)); 
        System.out.println("Cuisine Type: " + event.getInformation().get(3)); 
        System.out.println("Expected Time Of Meal: " + event.getInformation().get(4)); 
        System.out.println("Meal to be eaten daily during: " + event.getInformation().get(5)); 
        System.out.println("Meal to be eaten weekly during: " + event.getInformation().get(6)); 
        System.out.println("--------------------------------------------------"); 
        // Create an event notification for this event
        new Event_Notification(event);
      }
    }catch(IndexOutOfBoundsException e) {
      // Captures information to classify the following type of meal: mealIdea, dailyMeal
      System.out.println("End of execution for that publish event."); 
      new Event_Notification(event);
    }
  }

  public static void main(String[]args) {
    Event event1 = new Event("publish", Arrays.asList("pub1", "mealIdea", "Fried Rice", "Chinese", "15 minutes")); 
    //Event event2 = new Event("publish", Arrays.asList("pub1", "dailyMeal", "Fried Rice", "Chinese", "15 minutes", "breakfast")); 
    //Event event3 = new Event("publish", Arrays.asList("pub3", "dailyMeal", "Fried Rice", "Chinese", "15 minutes", "lunch")); 
    //Event event4 = new Event("publish", Arrays.asList("pub3", "weeklyMeal", "Fried Rice", "Chinese", "15 minutes", "dinner", "Monday")); 
    Publisher pub1 = new Publisher();
    pub1.publish_event(event1);
    //Publisher pub3 = new Publisher();
    //pub3.publish_event(event2);
    //pub3.publish_event(event3);
    //pub3.publish_event(event4);
    Subscriber subscriber1 = new Subscriber("customer1"); 
    // call subscribe/unsubscribe events
    System.out.println("Calling subscribe event function."); 
    subscriber1.subscribe_event(new Event("subscribe", Arrays.asList("customer1", "mealIdea")));
    subscriber1.subscription_info();
    //subscriber1.subscribe_event(new Event("subscribe", Arrays.asList("customer1", "dailyMeal")));
    //subscriber1.subscribe_event(new Event("subscribe", Arrays.asList("customer1", "weeklyMeal")));
    subscriber1.unsubscribe_event(new Event("unsubscribe", Arrays.asList("customer1", "mealIdea")));
    subscriber1.subscription_info();
    MessageBroker.loopThroughFullMapOrderingOfComponents();
    /*System.out.println("Calling unsubscribe event function.");
    subscriber1.unsubscribe_event(new Event("unsubscribe", Arrays.asList("customer1", "mealIdea")));
    subscriber1.subscription_info();
    MessageBroker.loopThroughFullMapOrderingOfComponents(); */
    // call subscribe/unsubscribe events

    /*Subscriber subscriber2 = new Subscriber("customer2"); 
    subscriber2.unsubscribe_event(new Event("unsubscribe", Arrays.asList("customer2", "dailyMeals")));
    subscriber2.subscription_info();

    // call subscribe/unsubscribe events

    Subscriber subscriber3 = new Subscriber("customer3"); 
    subscriber3.unsubscribe_event(new Event("subscribe", Arrays.asList("customer3", "Italian")));
    subscriber3.subscription_info();

    // call subscribe/unsubscribe events

    Subscriber subscriber4 = new Subscriber("customer4"); 
    subscriber4.unsubscribe_event(new Event("unsubscribe", Arrays.asList("customer4", "Brazilian")));
    subscriber4.subscription_info();

    // call subscribe/unsubscribe events

    Subscriber subscriber5 = new Subscriber("customer5"); 
    subscriber5.unsubscribe_event(new Event("unsubscribe", Arrays.asList("customer5", "weeklyMeals")));
    subscriber5.subscription_info();*/

    // call subscribe/unsubscribe events
    
  }
}
