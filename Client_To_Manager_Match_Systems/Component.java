package Client_To_Manager_Match_Systems;

import java.util.List;
/*
 * Class highlights
 * 1. Attributes
 *    - publisherName: String
 *    - subscriberName: String
 *    - eventsFullList: List<Event>
 * 2. Constructor
 *     - Takes in publisherName: String, subscriberName: String, and eventsFullList: List<Event>
 *     - Initializes attributes publisherName: String, subscriberName: String, and eventsFullList: List<Event>
 * 2. Operational Methods: 
 *     - addEvent(List<Event> events): void - Adds an event to list of events
 *     - removeEvent(Event event): void - Removes event from list of events
 * 3. Getter Methods: 
 *    - getListOfEvents(): Event - returns the list of events
 *    - getPublisherName(): String - returns the publisher name
 *    - getSubscriberName(): String - returns the subscriber name
 */
class Component {
  private String publisherName; 
  private String subscriberName;
  private List<Event> eventsFullList; 

  Component(String publisherName, String subscriberName, List<Event> events) {
    this.publisherName = publisherName;
    this.subscriberName = subscriberName;
    this.eventsFullList = events;
  }

  void addEvent(List<Event> events) {
    for(Event event: events) {
      eventsFullList.add(event); 
    } 
  }

  void removeEvent(Event event) {
    eventsFullList.remove(event); 
  }

  List<Event> getListOfEvents() {
    return eventsFullList;
  }

  String getPublisherName() {
    return publisherName;
  }

  String getSubscriberName() {
    return subscriberName;
  }
}
