package Category_Process;

import java.io.FileReader;
import java.io.IOException;

interface Module_Interpreter {
  static FileReader getFileReader() throws IOException {
    return new FileReader("category_compute.txt"); 
  }
}
