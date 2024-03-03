package Instruction_Sets;

import dataStructures.NodeStack;

public final class Instruction_Set_Breakpoint_1 {
  private static NodeStack<Instruction> instruction_set_1 = new NodeStack<Instruction>(); 

  static NodeStack<Instruction> getFirstInstructionSet() {
    return instruction_set_1; 
  }
}
