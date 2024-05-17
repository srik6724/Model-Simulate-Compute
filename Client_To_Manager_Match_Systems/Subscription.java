package Client_To_Manager_Match_Systems;

import java.util.ArrayList;
import java.util.List;
/*
 * Class Highlights: 
 *  1. Attributes
 *    - mealPlanType: String
 *    - notifications: List<Event>
 *  2. Constructor
 *    - Subscription(notification: Event) - add notification to event_list
 *    - Subscription(mealPlanType: String, notifications: List<Event>) - Initializes attributes mealPlayType: String, notifications: List<Event>
 *  3. Operational Methods
 *    - addNotification(notification: Event) : void - Adds notification to notifications: List<Event>
 *  4. Getter Methods
 *    - getMealPlanType(): String - Returns meal plan type
 *    - getNotifications(): List<Event> - Returns list of event notifications
 *  5. Setter Methods
 *    - setMealPlanType(mealPlanType: String): void - Sets meal plan type
 *    - setNotifications(notifications: List<Event>): void - Sets event notification list
 */

class Subscription {
  private String mealPlanType; 
  private List<Event> notifications = new ArrayList<Event>(); 

  Subscription(Event notification) {
    notifications.add(notification);
  }

  Subscription(String mealPlanType, List<Event> notifications) {
    this.mealPlanType = mealPlanType; 
    this.notifications = notifications; 
  }

  String getMealPlanType() {
    return this.mealPlanType; 
  }

  void setMealPlanType(String mealPlanType) {
    this.mealPlanType = mealPlanType;
  }

  void setNotifications(List<Event> notifications) {
    this.notifications = notifications;
  }

  List<Event> getNotifications() {
    return notifications; 
  }

  void addNotification(Event notification) {
    notifications.add(notification);
  }
}
