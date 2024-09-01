package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Verb_Discarder {
   
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("verb_excess_" + team + "_compute.txt");
  }

}
