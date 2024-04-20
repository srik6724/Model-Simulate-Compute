package wizPackage;

public interface Round {

  static int get_current_number() {
    return ++Number.count;
  }

}
