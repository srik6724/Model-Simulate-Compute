package Instruction_Sets;

import java.util.ArrayList;
import java.util.List;

import dataStructures.NodeStack;

public class Instruction_List {
  private List<NodeStack<Instruction>> fullInstructionList = new ArrayList<NodeStack<Instruction>>(); 

  {
    // Adding instructions sets to full instruction list
    fullInstructionList.add(Instruction_Set_Breakpoint_1.getFirstInstructionSet()); 
    fullInstructionList.add(Instruction_Set_Breakpoint_2.getSecondInstructionSet()); 
    fullInstructionList.add(Instruction_Set_Breakpoint_3.getThirdInstructionSet()); 
    fullInstructionList.add(Instruction_Set_Breakpoint_4.getFourthInstructionSet());
    fullInstructionList.add(Instruction_Set_Breakpoint_5.getFifthInstructionSet()); 
    fullInstructionList.add(Instruction_Set_Breakpoint_6.getSixthInstructionSet()); 
  }

  public List<NodeStack<Instruction>> getFullInstructionList() {
    return this.fullInstructionList;
  }

  
}
