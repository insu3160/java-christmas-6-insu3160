package christmas.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.contants.ErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderManagerTest {
    private OrderManager orderManager;

    @BeforeEach
    void setUp() {
        orderManager = new OrderManager();
    }

    @Test
    @DisplayName("유효한 주문인 경우 예외가 발생하지 않는다.")
    void testRecordOrders() {
        String[] inputOrders = {"샴페인-2", "해산물파스타-1"};

        assertDoesNotThrow(() -> orderManager.recordOrders(inputOrders));
    }

    @Test
    @DisplayName("메뉴 형식이 예시와 다른 경우 예외가 발생한다.")
    void testCheckMenuFormatValidity() {
        String[] inputOrders = {"샴페인", "해산물파스타-1"};

        assertThatThrownBy(() -> orderManager.recordOrders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("메뉴에 존재하지 않은 메뉴 입력 시 예외가 발생한다.")
    void testValidateThrowsExceptionForUnMatchedMenu() {
        String[] inputOrders = {"햄버거-1"};

        assertThatThrownBy(() -> orderManager.recordOrders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("음료만 시켰을 경우 예외가 발생한다.")
    void testValidateThrowsExceptionForOnlyBeverage() {
        String[] inputOrders = {"제로콜라-1", "레드와인-2"};

        assertThatThrownBy(() -> orderManager.recordOrders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("메뉴 갯수가 20개 초과일 경우 예외가 발생한다.")
    void testValidateThrowsExceptionForOverMenuQuantityLimit() {
        String[] inputOrders = {"샴페인-15", "해산물파스타-6"};

        assertThatThrownBy(() -> orderManager.recordOrders(inputOrders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }

}
