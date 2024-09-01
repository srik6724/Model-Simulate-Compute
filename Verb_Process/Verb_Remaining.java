package Verb_Process;

import java.io.FileWriter;
import java.io.IOException;

interface Verb_Remaining {
  static FileWriter getFileWriter(String team) throws IOException {
    return new FileWriter("verb_remaining_" + team + "_compute.txt");
  }
}
