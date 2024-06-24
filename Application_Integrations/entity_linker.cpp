// example.cpp
#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <cstdlib>
//#include <htable>
#include <unistd.h> // for sleep

// Connection Struct
struct Connection {
  void* ARROW_TRACE; 
};

// Property Struct 
struct Property {
  std::string classifer; 
  int position;
  std::string label; 
  std::string FUNCTION_DEF; 
  std::vector<long> timeframes;
  Connection pointer; 

  Property(std::string classifer, int position, std::string label, std::string FUNCTION_DEF, long timeframe) {
    this->classifer = classifer;
    this->position = position;
    this->label = label;
    this->FUNCTION_DEF = FUNCTION_DEF; 
    this->timeframes.push_back(timeframe);
  }
};

std::set<Property*> propertyBox;

int main() {
    std::string line_1;
    std::getline(std::cin, line_1); 
    std::cout << "PROPERTY CLASSIFIER: " << line_1 << std::endl;
    std::string line_2;
    std::getline(std::cin, line_2); 
    std::cout << "PROPERTY POSITION: " << line_2 << std::endl;
    std::string line_3;
    std::getline(std::cin, line_3); 
    std::cout << "PROPERTY LABEL: " << line_3 << std::endl;
    std::string line_4;
    std::getline(std::cin, line_4); 
    std::cout << "PROPERTY TIMEFRAME: " << line_4 << std::endl;
    std::string line_5;
    std::getline(std::cin, line_5); 

    Property* agent = new Property(line_1, std::stoi(line_2), line_3, line_4, std::stol(line_5));

    std::cout << "AGENT CLASSIFIER: " << agent->classifer << std::endl;
    std::cout << "AGENT POSITION: " << agent->position << std::endl;
    std::cout << "AGENT LABEL: " << agent->label << std::endl;
    std::cout << "AGENT FUNCTION DEF: " << agent->FUNCTION_DEF << std::endl;

    for(long timeframe: agent->timeframes) {
      std::cout << "AGENT TIMEFRAME: " << timeframe << std::endl;
    }

    std::cout << "Welcome to the entity_linker" << std::endl;
    std::cout << "Starting linking process...for agent_system" << std::endl;
    sleep(2); 
    std::cout << "Calling htable for entry -> template" << std::endl;
    
    return 0;
}