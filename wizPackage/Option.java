package wizPackage;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Option {

  private static boolean scannerInUse = false; 
	private static boolean fileInUse = false; 
  private static Scanner sc = new Scanner(System.in); 

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
    Option.sc.close();
  }

  public static void scannerOrfileOption() {  
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("File or Scanner? Write it as file or scanner.");
        try {
            String input = br.readLine();
            if(input.equals("file")) {
                Option.setFileInUse(true);
            } else if(input.equals("scanner")) {
                Option.setScannerInUse(true);
            }
            br.close(); // Close BufferedReader when done
        } catch (IOException e) {
            e.printStackTrace();
        }
  }
}
