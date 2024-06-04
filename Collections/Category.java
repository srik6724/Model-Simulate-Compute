package Collections;

import java.io.File;

public class Category<T> {

  private String name; 

  private Category() {
    
  }

  public Category(String name, File[] files) {
    this.name = name; 
    findCommonalities(files);
  }

  private void findCommonalities(File[] files) {
    
  }


}
