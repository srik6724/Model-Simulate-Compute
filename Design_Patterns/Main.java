package Design_Patterns;

import java.util.ArrayList;
import java.util.List;

interface Component {
  void display(); 
}

class Leaf implements Component {
  @Override
  public void display() {
    System.out.println("leaf"); 
  }
}

class Composite implements Component {
  List<Component> children = new ArrayList<>(); 

  public void add(Component component) {
    children.add(component);
  }

public void remove(Component component) {
    children.remove(component);
}

@Override
public void display() {
    System.out.println("Composite:");
    for (Component component : children) {
        component.display();
    }
}
  
}

public class Main {
  public static void main(String[]args) {
    Composite composite = new Composite();
    composite.add(new Leaf());
    Composite composite2 = new Composite();
    composite2.add(new Leaf());
    composite2.add(new Leaf());
    composite.add(composite2);
    composite.display();
  }
}
