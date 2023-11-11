package christmas.model;

import java.time.LocalDate;

public class VisitDate {
    private final LocalDate visitDate;

    public VisitDate(int visitDay) {
        this.visitDate = LocalDate.of(2023, 12, visitDay);
    }

}
