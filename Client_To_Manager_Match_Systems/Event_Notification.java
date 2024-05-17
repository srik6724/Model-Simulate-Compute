package Client_To_Manager_Match_Systems;

import java.util.List;
/*
 * Class Highlights: 
 *  1. Attributes
 *      - event: Event
 *  2. Constructor
 *      - Event_Notification(event: Event): Initializes event: Event, Creates subscription list, Either adds event to existing subscription, or creates new subscription
 *  3. Operational Methods
 *      - getNotification(): Event - returns event notification
 *  4. Instance Getter/Setter Methods:
 *      N/A
 *  5. Class Getter/Setter Methods: 
 *      N/A
 */

class Event_Notification {
  private Event event; 

  // Pass in the event object
  Event_Notification(Event event) {
    this.event = event; 
    // Initialize subscription_created to false
    boolean subscription_created = false; 
    // Create a new subscription list for initial processing of subscriptions
    Subscription_List list = new Subscription_List(); 
    // If subscription size is 0:
    // Creates a new subscription with information containing the types and the information about the meal plan
    if(list.getSubscriptions().size() == 0) {
      Subscription subscription = new Subscription(event);
      subscription.setMealPlanType(event.getInformation().get(1)); 
      System.out.println("Added subscription with meal plan type: " + subscription.getMealPlanType()); 
      subscription_created = true; 
    }
    // If subscription_created false, loop through existing list of subscriptions
    // Retrieve the notifications for that particular subscription and compare whether any event notifications match meal plan type.
    // If meal plan type matched, add event to existing subscription
    if(subscription_created == false) {
      for(Subscription subscription: list.getSubscriptions()) {
        List<Event> notifications = subscription.getNotifications(); 
        for(Event notification: notifications) {
          if(notification.getInformation().get(1).equals(event.getInformation().get(1))) {
            System.out.println("Name for Publisher already exists in list of event notifications. So adding new notification to the end of list."); 
            subscription.addNotification(event);
            subscription_created = true; 
            break;
          }
        }
      }
    }
    // Otherwise, create a new subscription for the event
    // Set the meal plan type and the event notifications
    // Add subscription to subscription_list
    if(subscription_created == false) {
      Subscription subscription = new Subscription(event);
      subscription.setMealPlanType(event.getInformation().get(1));
      List<Event> notifications = subscription.getNotifications();
      subscription.setNotifications(notifications);
      list.getSubscriptions().add(subscription);
      subscription_created = true; 
    }
  }

  // Returns event notification
  Event getNotification() {
    return event;
  }
}
