package Article_Process;

import java.io.FileWriter;
import java.io.IOException;

class CrossCheckPrFactsTeam1Writer {
  private static boolean writerCreated = false; 
  private static FileWriter file_writer; 
  

  CrossCheckPrFactsTeam1Writer(int round, String team) {
    try {
      file_writer = Cross_Check_pyreason_facts.getFileWriter(team, round);
      CrossCheckPrFactsTeam1Writer.writerCreated = true; 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static FileWriter get_file_writer(int round) {
    if(CrossCheckPrFactsTeam1Writer.writerCreated == false) {
      System.out.println("Calling round_pr_graph constructor."); 
      new CrossCheckPrFactsTeam1Writer(round, "t1"); 
    }
    return file_writer;
  }

  static void setWriterCreated(boolean var) {
    CrossCheckPrFactsTeam1Writer.writerCreated = var; 
  }
}
