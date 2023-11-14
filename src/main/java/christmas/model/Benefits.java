package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;

    public Benefits() {
        this.benefits = new ArrayList<>();
    }

    public void add(Benefit benefit) {
        this.benefits.add(benefit);
    }

}
