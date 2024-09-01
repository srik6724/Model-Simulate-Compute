package Verb_Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CrossCheckTeam1MemberSpellsWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4];  

  CrossCheckTeam1MemberSpellsWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Recorder.getFileWriter(team, memberNo, round); 
      CrossCheckTeam1MemberSpellsWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckTeam1MemberSpellsWriter.writerCreated == false) {
      System.out.println("Calling round_writer constructor"); 
      new CrossCheckTeam1MemberSpellsWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckTeam1MemberSpellsWriter.writerCreated = var; 
  }
}
