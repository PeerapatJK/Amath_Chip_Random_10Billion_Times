
public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            AmathRandom amathRandom = new AmathRandom();

            amathRandom.getRandom();

            amathRandom.getRandomNumber(1000 * 1000 * 1000);

//      amathRandom.printRandom();

            amathRandom.writeFile(String.valueOf(i));
        }
    }
}
