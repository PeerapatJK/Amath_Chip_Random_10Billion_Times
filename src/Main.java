
public class Main {

  public static void main(String[] args) {
    AmathRandom amathRandom = new AmathRandom();

    double index = 0.0;

    while (true) {

      amathRandom.getRandom();

      index += 1.0;
      if (index == 10000) {
        break;
      }
    }
    amathRandom.printRandom();
  }
}
