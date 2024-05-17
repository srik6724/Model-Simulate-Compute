package Client_To_Manager_Match_Systems;

import java.util.List;
/* 
  Class Highlights: 
    1. Attributes
       - type: String
       - information: List<String> 
    2. Constructor
        - Event(type: String, information: List<String>) : Initializes attributes type: String, information: List<String>
    3. Operational Methods
        N/A
    4. Getter Methods
        - getType(): String - returns type
        - getInformation(): List<String> - returns information list
 */
class Event {
  private String type; 
  private List<String> information; 

  Event(String type, List<String> information) {
    this.type = type; 
    this.information = information; 
  }

  String getType() {
    return type; 
  }

  List<String> getInformation() {
    return information; 
  }
}
