package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.contants.ErrorMessages;
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

}
