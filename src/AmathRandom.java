import java.util.*;

public class AmathRandom {

  List<Chip> aMathChip;
  Map<Rack, Integer> aMathRackCount;

  public AmathRandom() {
    this.aMathChip = new ArrayList<>();
    this.aMathRackCount = new HashMap<>();
    initAmathChip();
  }
  private void initAmathChip() {
    addChip(new Chip("(0)"), 5);
    addChip(new Chip("(1)"), 6);
    addChip(new Chip("(2)"), 6);
    addChip(new Chip("(3)"), 5);
    addChip(new Chip("(4)"), 5);
    addChip(new Chip("(5)"), 4);
    addChip(new Chip("(6)"), 4);
    addChip(new Chip("(7)"), 4);
    addChip(new Chip("(8)"), 4);
    addChip(new Chip("(9)"), 4);
    addChip(new Chip("(10)"), 2);
    addChip(new Chip("(11)"), 1);
    addChip(new Chip("(12)"), 2);
    addChip(new Chip("(13)"), 1);
    addChip(new Chip("(14)"), 1);
    addChip(new Chip("(15)"), 1);
    addChip(new Chip("(16)"), 1);
    addChip(new Chip("(17)"), 1);
    addChip(new Chip("(18)"), 1);
    addChip(new Chip("(19)"), 1);
    addChip(new Chip("(20)"), 1);
    addChip(new Chip("(+)"), 4);
    addChip(new Chip("(-)"), 4);
    addChip(new Chip("(+-)"), 5);
    addChip(new Chip("(*)"), 4);
    addChip(new Chip("(/)"), 4);
    addChip(new Chip("(*/)"), 4);
    addChip(new Chip("(?)"), 4);
    addChip(new Chip("(=)"), 11);

    System.out.println(aMathChip.size());
  }

  private void addChip(Chip chip, int amount) {

    for (int i = 0; i < amount; i++) {
      aMathChip.add(chip);
    }
  }

  public void getRandom() {
    Collections.shuffle(aMathChip);
    Rack rack = new Rack(aMathChip.subList(0, 8));

    if (!aMathRackCount.containsKey(rack)) {
      aMathRackCount.put(rack, 1);
    } else {
      aMathRackCount.put(rack, aMathRackCount.get(rack) + 1);
    }
  }
  public void printRandom() {
    for (Map.Entry<Rack, Integer> entry : aMathRackCount.entrySet()) {
      Rack key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(value.toString() + key.toString());
    }
  }
}
