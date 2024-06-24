package Domain_Process;

public interface Module {

  static int get_current_number() {
    return ++Number.count;
  }

}
