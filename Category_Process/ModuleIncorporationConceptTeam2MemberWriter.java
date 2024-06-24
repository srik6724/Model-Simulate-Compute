package Category_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleIncorporationConceptTeam2MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleIncorporationConceptTeam2MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      ModuleIncorporationConceptTeam2MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleIncorporationConceptTeam2MemberWriter.writerCreated == false) {
      new ModuleIncorporationConceptTeam2MemberWriter("t2", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleIncorporationConceptTeam2MemberWriter.writerCreated = var; 
  }
}
