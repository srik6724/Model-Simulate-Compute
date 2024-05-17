package Client_To_Manager_Match_Systems;

import java.util.ArrayList;
import java.util.List;

/*
 * Class Highlights: 
 *  1. Instance Variables
 *     - name: String
 *  2. Class Variables
 *     - subscriptions: static List<Subscription>
 *     - numberOfSubscriptions: static int
 *     - notification_meal_plan: static boolean
 *     - notification_daily_meal_plan: static boolean 
 *     - notification_weekly_meal_plan: static boolean
 *     - notification_generic: static boolean
 *  3. Constructor
 *      - Subscriber(name: String) - Initializes attribute name: String, Displays subscription information from subscription list
 *       and event_notifications from each subscription. Creates potential subscriber queue and adds subscription
 *  4. Operational Methods
 *      - subscribe_event(event: Event): void
 *      - unsubscribe_event(event: Event): void
 *      - addSubscription(subscription: Subscription): void - Adds subscription to subscription_list
 *      - subscription_info(): void - Returns subscription_info associated with subscriber
 *  5. Instance Getter/Setter Methods
 *      - getName(): String - Returns subscriber name
 *      - getPotentialSubscriptions(): Subscription - Returns potential subscription_list
 *  6. Class Getter/Setter Methods
 *      - getNotificationMealPlan(): static boolean - returns meal plan flag
 *      - getNotificationDailyPlan(): static boolean - returns daily plan flag
 *      - getNotificationWeeklyPlan(): static boolean - returns weekly plan flag
 *      - getNotificationGeneric(): static boolean - returns generic flag
 *      - setNotificationMealPlan(flag: boolean): static boolean - sets meal plan flag
 *      - setNotificationDailyPlan(flag: boolean): static boolean - sets daily plan flag
 *      - setNotificationWeeklyPlan(flag: boolean): static boolean - sets weekly plan flag
 *      - setNotificationGeneric(flag: boolean): static boolean - sets generic flag
 */

class Subscriber {
  private String name; 
  private static List<Subscription> subscriptions = new ArrayList<Subscription>();
  private static int numberOfSubscriptions = 0; 
  private static boolean notification_meal_plan = false; 
  private static boolean notification_daily_meal_plan = false;  
  private static boolean notification_weekly_meal_plan = false; 
  private static boolean notification_generic = false; 

  Subscriber(String name) {
    this.name = name;
    if(Subscriber.numberOfSubscriptions == 0) {
      // Select a subscription to subscribe to from list
      System.out.println("Displaying information about each subscription."); 
      // Creates a new subscription list for subscriber object
      for(Subscription subscription: new Subscription_List().getSubscriptions()) {
        System.out.println("---------------------------------------------"); 
        System.out.println("Meal Plan Type: " + subscription.getMealPlanType());
        for(Event notification: subscription.getNotifications()) {
          System.out.println("Type of Plan Category: " + notification.getType()); 
          try {
            System.out.println("------------------------------------------------------------------------"); 
            System.out.println("Event Publisher Name: " + notification.getInformation().get(0));
            System.out.println("Event Type Of Plan: " + notification.getInformation().get(1));
            System.out.println("Event Food Name: " + notification.getInformation().get(2));
            System.out.println("Event Cuisine Type: " + notification.getInformation().get(3));
            System.out.println("Event Expected Time Of Meal: " + notification.getInformation().get(4));
            System.out.println("Event Meal to be eaten daily during: " + notification.getInformation().get(5)); 
            System.out.println("Event Meal to be eaten weekly during: " + notification.getInformation().get(6)); 
            System.out.println("---------------------------------------------------------------------------");  
          }catch(IndexOutOfBoundsException e) {
            System.out.println("Notifications fully read within the subscription."); 
          } 
        }
        // Adds that subscription to the specified subscriber's subscriptions list
        Subscriber.addSubscription(subscription);
        // Creating a component for the 
        // For any events later added, make sure to add it to the component in the future
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
        System.out.println("Subscription added to subscriber queue for " + name + " to choose from later of meal plan type " + subscription.getMealPlanType());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------"); 
        } 
      }
  }

  public String getName() {
    return name; 
  }

  public static boolean getNotificationMealPlan() {
    return Subscriber.notification_meal_plan; 
  }

  public static boolean getNotificationDailyPlan() {
    return Subscriber.notification_daily_meal_plan; 
  }

  public static boolean getNotificationWeeklyPlan() {
    return Subscriber.notification_weekly_meal_plan; 
  }

  public static boolean getNotificationGeneric() {
    return Subscriber.notification_generic; 
  }

  public static void setNotificationMealPlan(boolean var) {
    Subscriber.notification_meal_plan = var; 
  }

  public static void setNotificationDailyPlan(boolean var) {
    Subscriber.notification_daily_meal_plan = var; 
  }

  public static void setNotificationWeeklyPlan(boolean var) {
    Subscriber.notification_weekly_meal_plan = var; 
  }

  public static void setNotificationGeneric(boolean var) {
    Subscriber.notification_generic = var; 
  }

  public static void addSubscription(Subscription subscription) {
    Subscriber.subscriptions.add(subscription);
  }

  public static List<Subscription> getPotentialSubscriptions() {
    return Subscriber.subscriptions;
  }

  // Checks boolean flags (generic, meal-plan, daily-plan, weekly-plan) and prints in-console 
  // whether subscriber's notifications for those flag are on or off
  void subscription_info() {
    if(Subscriber.getNotificationGeneric() == true) {
      System.out.println("Subscriber " + name + " is subscribed to generic notifications regarding meal idea."); 
    }
    else if(Subscriber.getNotificationMealPlan() == true) {
      System.out.println("Subscriber " + name + " is subscribed to meal notifications regarding meal plan of Brazilian, Chinese, or Italian."); 
    }
    else if(Subscriber.getNotificationDailyPlan() == true) {
      System.out.println("Subscriber " + name + " is subscribed to daily notifications regarding daily plan."); 
    }
    else if(Subscriber.getNotificationWeeklyPlan() == true) {
      System.out.println("Subscriber " + name + " is subscribed to weekly notifications regarding weekly plan.");
    }
    else {
      System.out.println("Subscriber " + name + " is not currently subscribed to any type of notifications.");
    }
  }
    // Subscribe_event initiated from a subscriber, given that association with publisher exists
    // Otherwise if event cannot be detected from subscription list, no flags are set and
    // MessageBroker Component list is not updated
   void subscribe_event(Event event) {
    for(Subscription subscription: Subscriber.getPotentialSubscriptions())
    if(subscription != null) {
      // Checks for event type (subscribe)
      if(event.getType().equals("subscribe")) {
        // Locate the event_notification you are looking for within the subscription
        String subscribeType = event.getInformation().get(1); 
        //System.out.println("Subscribe Type: " + subscribeType);
        for(Event notification: subscription.getNotifications()) {
          // Match notification information meal plan to subscribeType meal plan if applicable
          // Create a component -> add component to message_broker list
          if(notification.getInformation().get(1).equals("mealIdea") && subscribeType.equals("mealIdea")) {
            String publisherName = notification.getInformation().get(0); 
            if(MessageBroker.getFullMapOrderingOfComponents().size() == 0) {
              Component component = new Component(publisherName, name, subscription.getNotifications());
              MessageBroker.add_component(component);
            }
            /*else {
              for(Integer id: MessageBroker.getFullMapOrderingOfComponents().keySet()) {
                List<Event> events = MessageBroker.getFullMapOrderingOfComponents().get(id).getListOfEvents();
                for(Event get_event: events) {
                  if(get_event.getInformation().get(1).equals("dailyMeal")) {
                    Component component = MessageBroker.getFullMapOrderingOfComponents().get(id); 
                    component.addEvent(subscription.getNotifications());
                  }
                }
              }
            }*/
            // Set generic notifications of subscriber to true
            Subscriber.setNotificationGeneric(true); 
          }
          // Match notification information dailyMeal plan to subscribeType dailyMeal plan if applicable
          // Create a component -> add component to message_broker list
          else if(notification.getInformation().get(1).equals("dailyMeal") && subscribeType.equals("dailyMeal")) {
            String publisherName = notification.getInformation().get(0); 
            if(MessageBroker.getFullMapOrderingOfComponents().size() == 0) {
              Component component = new Component(publisherName, name, subscription.getNotifications());
              MessageBroker.add_component(component);
            }
            else {
              for(Integer id: MessageBroker.getFullMapOrderingOfComponents().keySet()) {
                List<Event> events = MessageBroker.getFullMapOrderingOfComponents().get(id).getListOfEvents();
                for(Event get_event: events) {
                  if(get_event.getInformation().get(1).equals("dailyMeal")) {
                    Component component = MessageBroker.getFullMapOrderingOfComponents().get(id); 
                    component.addEvent(subscription.getNotifications());
                  }
                }
              }
            }
            Subscriber.setNotificationDailyPlan(true);
          }
          // Match notification information weeklyMeal plan to subscribeType weeklyMeal plan if applicable
          // Create a component -> add component to message_broker list
          else if(notification.getInformation().get(1).equals("weeklyMeal") && subscribeType.equals("weeklyMeal")) {
            String publisherName = notification.getInformation().get(0); 
            if(MessageBroker.getFullMapOrderingOfComponents().size() == 0) {
              Component component = new Component(publisherName, name, subscription.getNotifications());
              MessageBroker.add_component(component);
            }
            else {
              for(Integer id: MessageBroker.getFullMapOrderingOfComponents().keySet()) {
                List<Event> events = MessageBroker.getFullMapOrderingOfComponents().get(id).getListOfEvents();
                for(Event get_event: events) {
                  if(get_event.getInformation().get(1).equals("dailyMeal")) {
                    Component component = MessageBroker.getFullMapOrderingOfComponents().get(id); 
                    component.addEvent(subscription.getNotifications());
                  }
                }
              }
            }
            Subscriber.setNotificationWeeklyPlan(true);
          }
          // Match notification information cuisine to subscribeType cuisine if applicable
          // Create a component -> add component to message_broker list
          // Set flags based on meal plan -> dailyMeal or meal plan-> weeklyMeal or meal plan-> generic
          else if((subscribeType.equals("Italian") || subscribeType.equals("Brazilian") || subscribeType.equals("Chinese")) && (notification.getInformation().get(3).equals("Italian") || notification.getInformation().get(3).equals("Brazilian") || notification.getInformation().get(3).equals("Chinese"))) {
            Subscriber.setNotificationMealPlan(true);
            try {
              if(notification.getInformation().get(5).equals("dailyMeal")) {
                Subscriber.setNotificationDailyPlan(true);
              }
            }
            catch(IndexOutOfBoundsException e) {
              Subscriber.setNotificationDailyPlan(false);
            }
            try {
              if(notification.getInformation().get(5).equals("weeklyMeal")) {
                Subscriber.setNotificationWeeklyPlan(true);
              }
            } catch(IndexOutOfBoundsException e) {
              Subscriber.setNotificationWeeklyPlan(false);
            }
            if(Subscriber.getNotificationDailyPlan() == false && Subscriber.getNotificationWeeklyPlan() == false) {
              Subscriber.setNotificationGeneric(true);
            }
          }
        }
      }
    }
  }
  // Unsubscribe_event initiated from a subscriber, given that association with publisher exists
  // Otherwise, if event not detected, no flags are set
  void unsubscribe_event(Event event) {
   for(Subscription subscription: Subscriber.getPotentialSubscriptions()) {
    if(subscription != null) {
      if(event.getType().equals("unsubscribe")) {
        // Locate the event_notification you are looking for within the subscription
        String unsubscribeType = event.getInformation().get(1); 
        for(Event notification: subscription.getNotifications()) {
          if(notification.getInformation().get(1).equals("mealIdea") && unsubscribeType.equals("mealIdea")) {
            /*for(Integer id: MessageBroker.getFullMapOrderingOfComponents().keySet()) {
              String customerName = MessageBroker.getFullMapOrderingOfComponents().get(id).getSubscriberName();
              if(event.getInformation().get(0).equals(customerName)) {
                List<Event> events = MessageBroker.getFullMapOrderingOfComponents().get(id).getListOfEvents();
                for(Event get_event: events) {
                  if(get_event.getInformation().get(1).equals(unsubscribeType)) {
                    Component component = MessageBroker.getFullMapOrderingOfComponents().get(id); 
                    component.removeEvent(get_event);
                  }
                }
              }
            }*/
            Subscriber.setNotificationGeneric(false); 
          }
          else if(notification.getInformation().get(1).equals("dailyMeal") && unsubscribeType.equals("dailyMeal")) {
            //System.out.println("Found unsubscribe type of " + unsubscribeType);
            Subscriber.setNotificationDailyPlan(false);
          }
          else if(notification.getInformation().get(1).equals("weeklyMeal") && unsubscribeType.equals("weeklyMeal")) {
            //System.out.println("Found unsubscribe type of " + unsubscribeType);
            Subscriber.setNotificationWeeklyPlan(false);
          }
          else if((unsubscribeType.equals("Italian") || unsubscribeType.equals("Brazilian") || unsubscribeType.equals("Chinese")) && (notification.getInformation().get(3).equals("Italian") || notification.getInformation().get(3).equals("Brazilian") || notification.getInformation().get(3).equals("Chinese"))) {
            //System.out.println("Found unsubscribe type of " + unsubscribeType);
            Subscriber.setNotificationMealPlan(false);
            try {
              if(notification.getInformation().get(5).equals("dailyMeal")) {
                Subscriber.setNotificationDailyPlan(true);
              }
            }
            catch(IndexOutOfBoundsException e) {
              Subscriber.setNotificationDailyPlan(false);
            }
            try {
              if(notification.getInformation().get(5).equals("weeklyMeal")) {
                Subscriber.setNotificationWeeklyPlan(true);
              }
            } catch(IndexOutOfBoundsException e) {
              Subscriber.setNotificationWeeklyPlan(false);
            }
            if(Subscriber.getNotificationDailyPlan() == false && Subscriber.getNotificationWeeklyPlan() == false) {
              Subscriber.setNotificationGeneric(true);
            }
          }
        }
      }
    }
  }
  }
}
