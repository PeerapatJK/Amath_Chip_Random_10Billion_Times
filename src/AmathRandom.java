import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class AmathRandom {

  List<String> aMathChip;
  List<Chip> aMathChipCount;

  public AmathRandom() {
    this.aMathChip = new ArrayList<>();
    this.aMathChipCount = new ArrayList<>();
    initAmathChip();
  }
  private void initAmathChip() {
    addChip("0", 5);
    addChip("1", 6);
    addChip("2", 6);
    addChip("3", 5);
    addChip("4", 5);
    addChip("5", 4);
    addChip("6", 4);
    addChip("7", 4);
    addChip("8", 4);
    addChip("9", 4);
    addChip("10", 2);
    addChip("11", 1);
    addChip("12", 2);
    addChip("13", 1);
    addChip("14", 1);
    addChip("15", 1);
    addChip("16", 1);
    addChip("17", 1);
    addChip("18", 1);
    addChip("19", 1);
    addChip("20", 1);
    addChip("+", 4);
    addChip("-", 4);
    addChip("+-", 5);
    addChip("*", 4);
    addChip("/", 4);
    addChip("*/", 4);
    addChip("?", 4);
    addChip("=", 11);

    System.out.println(aMathChip.size());
  }

  private void addChip(String chip, int amount) {

    aMathChipCount.add(new Chip(chip,BigInteger.valueOf(0)));

    for (int i = 0; i < amount; i++) {
      aMathChip.add(chip);
    }
  }

  public void printRandom(){

    aMathChipCount = aMathChipCount.stream().sorted().collect(toList());

    for (Chip chip : aMathChipCount){
      System.out.println(chip.getChip()+ " " + chip.getCount());
    }
  }

  public void getRandom() {
    int rnd = new Random().nextInt(aMathChip.size());
    String key = aMathChip.get(rnd);
    aMathChipCount.stream().filter(e -> key.equals(e.getChip())).findFirst().get().incCount();
  }
}
