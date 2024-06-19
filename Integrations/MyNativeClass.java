
public class MyNativeClass {
  // Declare the native method
  public native void myNativeMethod();

  // Load the native library
  static {
      System.loadLibrary("MyNativeLibrary");
  }

  public static void main(String[] args) {
      MyNativeClass obj = new MyNativeClass();
      obj.myNativeMethod(); // Call the native method
      System.out.println(";lakjfas");
  }
}
