package Second_Process;

import java.io.FileWriter;
import java.io.IOException;

class NanosecondCombineTeam1MemberWriter {
  private static boolean writerCreated = false; 
  static FileWriter[] file_writers = new FileWriter[4]; 
  
  NanosecondCombineTeam1MemberWriter(String team, int memberNo, int round) {
    try {
      file_writers[memberNo-1] = Nanosecond_Merge_Finalizer.getFileWriter(team, memberNo, round);
      NanosecondCombineTeam1MemberWriter.writerCreated = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void get_file_writer(int round, int memberNo) {
    if(NanosecondCombineTeam1MemberWriter.writerCreated == false) {
      new NanosecondCombineTeam1MemberWriter("t1", memberNo, round);
    }
  }

  static void setWriterCreated(boolean var) {
    NanosecondCombineTeam1MemberWriter.writerCreated = var; 
  }
}
