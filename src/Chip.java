import java.math.BigInteger;

public class Chip implements Comparable{
  private String chip;
  private BigInteger count;
  public Chip(String chip, BigInteger count) {
    this.chip = chip;
    this.count = count;
  }
  public String getChip() {
    return chip;
  }
  public void setChip(String chip) {
    this.chip = chip;
  }
  public BigInteger getCount() {
    return count;
  }
  public void setCount(BigInteger count) {
    this.count = count;
  }

  public void incCount(){
    this.count = this.count.add(BigInteger.valueOf(1));
  }

  @Override
  public int compareTo(Object o) {
    return -count.compareTo(((Chip) o).getCount());
  }
}
