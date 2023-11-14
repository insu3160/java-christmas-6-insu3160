package christmas.model;

import christmas.contants.ErrorMessages;
import christmas.service.dto.VisitDateDto;
import java.time.LocalDate;

public class VisitDate {
    private final static int START_DAY = 1;
    private final static int END_DAY = 31;
    private final LocalDate visitDate;

    public VisitDate(int visitDay) {
        validate(visitDay);
        this.visitDate = LocalDate.of(2023, 12, visitDay);
    }

    private void validate(int visitDay) {
        ensureValidDay(visitDay);
    }

    private void ensureValidDay(int visitDay) {
        if (visitDay < START_DAY || visitDay > END_DAY) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DATE_ERROR_MESSAGE);
        }
    }

    public VisitDateDto convertToVisitDateDto() {
        return new VisitDateDto(this.visitDate);
    }

}
