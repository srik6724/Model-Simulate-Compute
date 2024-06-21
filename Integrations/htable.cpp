#include <iostream>
#include <string>
#include <vector>
#include <any>
#include <set>

// Property Struct 
struct Property {
  std::string classifer; 
  int position;
  char label; 
  std::any FUNCTION_DEF; 
  std::vector<long> timeframes;
  Connection pointer; 

  Property(std::string classifer, int position, char label, std::any FUNCTION_DEF, std::vector<long> timeframes) {
    this->classifer = classifer;
    this->position = position;
    this->label = label;
    this->FUNCTION_DEF = FUNCTION_DEF; 
    this->timeframes = timeframes;
    pointer.ARROW_TRACE = NULL;
  }
};

struct Connection {
  std::any ARROW_TRACE; 
};

std::set<Property*> propertyBox;




