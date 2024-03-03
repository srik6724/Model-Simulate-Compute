package Testing;

import java.io.Serializable;

public class ApplicationState<T> implements Serializable {
  
  private T data; 
  private String STATE_FILE_PATH; 

  public ApplicationState(T data, String STATE_FILE_PATH) {
    this.data = data; 
    this.STATE_FILE_PATH = STATE_FILE_PATH;
  }

  public T getData() {
    return data; 
  }

  public void setData(T data) {
    this.data = data; 
  }

  public String getFilePath() {
    return this.STATE_FILE_PATH;
  }


}
