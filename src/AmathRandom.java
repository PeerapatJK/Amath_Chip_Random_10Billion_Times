import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class AmathRandom {

  List<Chip> aMathChip;
  Map<String, Integer> aMathRackCount;
  int times = 1;

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
    String rackString = rack.toString();
    if (!aMathRackCount.containsKey(rackString)) {
      aMathRackCount.put(rackString, 1);
    }
    else {
      aMathRackCount.put(rackString, aMathRackCount.get(rackString) + 1);
    }
  }

  public void printRandom() {
    for (Map.Entry<String, Integer> entry : aMathRackCount.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(value.toString() + " "+ key.toString());
    }
  }
  public void getRandomNumber(int times) {
    this.times = times;
    for (int i=0;i<times;i++){
      getRandom();
    }
  }

  public boolean writeFile(String fileName){
    File file = new File(fileName + "_output.txt");

    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(aMathRackCount.entrySet());
    Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
    {
      public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
      {
        return (o2.getValue()).compareTo( o1.getValue() );
      }
    } );

    try (FileOutputStream fop = new FileOutputStream(file)) {

      // if file doesn't exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      final PrintStream printStream = new PrintStream(fop);
      for (Map.Entry<String, Integer> entry:list) {
        String key = entry.getKey();
        Integer value = entry.getValue();
        printStream.println(value.toString() + " "+ key.toString());
      }
      printStream.close();

      fop.flush();
      fop.close();

      System.out.println("Done");

    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }
}
