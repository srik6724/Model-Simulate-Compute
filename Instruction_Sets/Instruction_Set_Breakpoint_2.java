package Instruction_Sets;

import dataStructures.NodeStack;

public final class Instruction_Set_Breakpoint_2 {
  private static NodeStack<Instruction> instruction_set_2 = new NodeStack<Instruction>(); 
  
  static NodeStack<Instruction> getSecondInstructionSet() {
    return instruction_set_2; 
  }
}
