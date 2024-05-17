package wizPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXInputExample extends Application {

  public static void main(String[]args) {
    //launch(args); 
    
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    TextField textField = new TextField(); 
    Button button = new Button("Submit"); 
    button.setOnAction(e -> {
            String input = textField.getText();
            System.out.println("You entered: " + input);
        });

    VBox vbox = new VBox(textField, button);
    Scene scene = new Scene(vbox, 300, 200);

    primaryStage.setTitle("JavaFX Input Example");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
}
