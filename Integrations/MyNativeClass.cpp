#include <jni.h>
#include <iostream>
#include "MyNativeClass.h"

// Implement the native method
JNIEXPORT void JNICALL Java_MyNativeClass_myNativeMethod(JNIEnv *env, jobject obj) {
    std::cout << "Hello from native C++ code!" << std::endl;
    int x = 3; 
    for(int i = 0; i < x; i++) {
        std::cout << "Value Of i: " << i << std::endl; 
    }
}

int main() {
    return 0; // Required to avoid linker error for missing main
}