package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.contants.ErrorMessages;
import christmas.service.dto.VisitDateDto;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDateTest {
    @Test
    @DisplayName("1 이상 31 이하의 방문 날짜가 아닐 경우 예외 처리한다.")
    void inputInvalidVisitDate() {
        assertThatThrownBy(() -> new VisitDate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_DATE_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("VisitDateDto를 잘 반환하는지 확인한다.")
    void testConvertToVisitDateDto() {
        VisitDate visitDate = new VisitDate(15);
        VisitDateDto visitDateDto = visitDate.convertToVisitDateDto();
        assertThat(visitDateDto.visitDate()).isEqualTo(LocalDate.of(2023, 12, 15));
    }

    @Test
    @DisplayName("크리스마스 D-DAY를 잘 반환하는지 확인한다.")
    void testGetChristMasDday() {
        VisitDate visitDate = new VisitDate(15);

        assertThat(visitDate.getChristMasDday()).isEqualTo(10);
    }

    @Test
    @DisplayName("방문 날짜가 주말일 때 true를 반환한다.")
    void testIsWeekend() {
        VisitDate visitDate = new VisitDate(23); // Saturday

        assertThat(visitDate.isWeekend()).isTrue();
    }

    @Test
    @DisplayName("방문 날짜가 특별 할인 받는 날짜일 때 true를 반환한다.")
    void testIsSpecialDay() {
        VisitDate visitDate = new VisitDate(25);

        assertThat(visitDate.isSpecialDay()).isTrue();
    }

}
