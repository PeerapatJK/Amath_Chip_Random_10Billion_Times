import java.util.List;

import static java.util.stream.Collectors.toList;

public class Rack {

    private List<Chip> chips;

    public Rack(List<Chip> chips) {
        this.chips = chips.stream().sorted().collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rack)) return false;

        Rack rack = (Rack) o;

        return chips.equals(rack.chips);
    }

    @Override
    public int hashCode() {
        return chips.hashCode();
    }

    @Override
    public String toString() {
        return "Rack{" +
                "chips=" + chips +
                '}';
    }
}
