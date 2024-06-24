package Category_Process;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Option {

  private static boolean scannerInUse = false; 
	private static boolean fileInUse = false; 
  private static Scanner sc;

	public static void setScannerInUse(boolean temp) {
		Option.scannerInUse = temp;
	}

	public static void setFileInUse(boolean temp) {
		Option.fileInUse = temp; 
	}

  public static boolean getScannerInUse() {
    return Option.scannerInUse;
  }

  public static boolean getFileInUse() {
    return Option.fileInUse;
  }

  public static void closeScannerForOptionChosen() {
    sc.close();
  }

  public static void openScanner() {
    sc = new Scanner(System.in); 
  }

  public static void scannerOrfileOption() {  
     Option.openScanner();
     System.out.println("File or Scanner? Write it as file or scanner."); 
     String input = sc.nextLine(); 
     System.out.println("Input selected: " + input); 
     if(!sc.hasNextLine()) {
      Option.closeScannerForOptionChosen();
     }
     if(input.equals("file")) {
      Option.setFileInUse(true);
     }
     else if(input.equals("scanner")) {
      Option.setScannerInUse(true);
     }
  }
}
