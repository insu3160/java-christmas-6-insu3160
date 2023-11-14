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

}
