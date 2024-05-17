package Client_To_Manager_Match_Systems;

import java.util.ArrayList;
import java.util.List;
/*
 * Class Highlights: 
 * 1. Attributes
 *     - setOnce: static boolean
 *     - subscriptions: static List<Subscription>
 * 2. Constructor
 *     - Subscription_List(): Initializes the subscription list if null
 * 3. Operational Methods
 *     N/A
 * 4. Getter Methods
 *     - getSubscriptions(): List<Subscription> - returns the list of subscriptions
 */

class Subscription_List {
  static boolean setOnce = false; 
  static List<Subscription> subscriptions; 

  Subscription_List() {
    if(setOnce == false) {
      subscriptions = new ArrayList<Subscription>(); 
      setOnce = true;
    }
  }

  public List<Subscription> getSubscriptions() {
    return subscriptions; 
  }
}
