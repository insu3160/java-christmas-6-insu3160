package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.contants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuQuantityTest {
    @Test
    @DisplayName("MenuQuantity가 잘 생성되는지 확인한다.")
    void testValidMenuQuantity() {
        int validQuantity = 3;
        MenuQuantity menuQuantity = new MenuQuantity(3);

        assertThat(menuQuantity.getMenuQuantity()).isEqualTo(validQuantity);
    }

    @Test
    @DisplayName("메뉴 갯수가 1개 미만일 경우 예외가 발생한다.")
    void testInvalidMenuQuantity() {
        assertThatThrownBy(() -> new MenuQuantity(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }

}
