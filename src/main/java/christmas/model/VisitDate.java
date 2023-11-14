package christmas.model;

import christmas.contants.ErrorMessages;
import christmas.service.dto.VisitDateDto;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private final static int CHRISTMAS_DAY = 25;
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

    public int getChristMasDday() {
        return CHRISTMAS_DAY - visitDate.getDayOfMonth();
    }

    public boolean isWeekend() {
        return visitDate.getDayOfWeek() == DayOfWeek.FRIDAY || visitDate.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

}
