package Logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {
    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

    public void myMethod() {
        // Check if the logging should be executed
        boolean x = true; 
        if (x) {
            logger.info("This logging statement will execute.");
            x = false; 
        } else {
            // Do nothing or log a different message
            logger.info("This logging statement will not execute.");
        }
    }
}