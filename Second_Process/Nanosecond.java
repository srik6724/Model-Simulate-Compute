package Second_Process;

public interface Nanosecond {

  static int get_current_number() {
    return ++Number.count;
  }

}
