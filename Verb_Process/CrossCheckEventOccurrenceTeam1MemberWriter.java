package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckEventOccurrenceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  CrossCheckEventOccurrenceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Cross_Check_Timestamp.getFileWriter(team, memberNo, round); 
      CrossCheckEventOccurrenceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(CrossCheckEventOccurrenceTeam1MemberWriter.writerCreated == false) {
      new CrossCheckEventOccurrenceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    CrossCheckEventOccurrenceTeam1MemberWriter.writerCreated = var; 
  }
}
