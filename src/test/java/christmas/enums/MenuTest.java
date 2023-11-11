package christmas.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.contants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @Test
    @DisplayName("메뉴판에 메뉴가 존재 할 시 Menu로 반환한다.")
    void returnMenuIfExistsOnMenuBoard() {
        assertThat(Menu.findMenu("양송이수프")).isEqualTo(Menu.YANGSONG_SOUP);
    }

    @Test
    @DisplayName("메뉴판에 없는 메뉴를 입력하였을 경우 예외 처리한다.")
    void inputUnrecognizedMenu() {
        assertThatThrownBy(() -> Menu.findMenu("영화"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }

}
