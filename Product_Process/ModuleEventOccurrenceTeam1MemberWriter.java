package Product_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleEventOccurrenceTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleEventOccurrenceTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Timestamp.getFileWriter(team, memberNo, round); 
      ModuleEventOccurrenceTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleEventOccurrenceTeam1MemberWriter.writerCreated == false) {
      new ModuleEventOccurrenceTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleEventOccurrenceTeam1MemberWriter.writerCreated = var; 
  }
}
