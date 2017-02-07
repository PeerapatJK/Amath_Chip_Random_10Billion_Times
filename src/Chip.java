public class Chip implements Comparable {
    private String chip;

    public Chip(String chip) {
        this.chip = chip;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    @Override
    public int compareTo(Object o) {
        return -chip.compareTo(((Chip) o).getChip());
    }

    @Override
    public String toString() {
        return this.chip;
    }
}
