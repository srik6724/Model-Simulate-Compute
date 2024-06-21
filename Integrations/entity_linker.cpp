// example.cpp
#include <iostream>
//#include <htable>
#include <unistd.h> // for sleep

int main() {
    std::string input;
    std::getline(std::cin, input);
    std::cout << "Received from Java: " << input << std::endl;
    std::cout << "Welcome to the entity_linker" << std::endl;
    std::cout << "Starting linking process...for agent_system" << std::endl;
    sleep(2); 
    std::cout << "Calling htable for entry -> template" << std::endl;
    return 0;
}