package Domain_Process;

import java.io.FileWriter;
import java.io.IOException;

class ModuleIncorporationConceptTeam1MemberWriter {
   private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 

  ModuleIncorporationConceptTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Module_Incorporation_Concept.getFileWriter(team, memberNo, round); 
      ModuleIncorporationConceptTeam1MemberWriter.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(ModuleIncorporationConceptTeam1MemberWriter.writerCreated == false) {
      new ModuleIncorporationConceptTeam1MemberWriter("t1", memberNo, round); 
    }
  }

  static void setWriterCreated(boolean var) {
    ModuleIncorporationConceptTeam1MemberWriter.writerCreated = var; 
  }
}
