package Testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import wizPackage.Match;

public class StatePersistence {
  /*
   * Creating class methods for usage in StatePersistence class
   */
  private ApplicationState<Object> state; 

  public StatePersistence(ApplicationState<Object> state) {
    this.state = state; 
  }
  
  public void saveState() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.state.getFilePath()))) {
      oos.writeObject(state);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  public ApplicationState<Object> loadState() {
      ApplicationState<Object> state = null;
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.state.getFilePath()))) {
          state = (ApplicationState<Object>) ois.readObject();
      } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace();
      }
      return state; 
  }

}
