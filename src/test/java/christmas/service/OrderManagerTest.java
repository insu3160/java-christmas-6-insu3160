package christmas.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderManagerTest {
    @Test
    @DisplayName("유효한 주문인 경우 예외가 반환되지 않는다.")
    void testRecordOrders() {
        OrderManager orderManager = new OrderManager();
        String[] inputOrders = {"샴페인-2", "해산물파스타-1"};

        assertDoesNotThrow(() -> orderManager.recordOrders(inputOrders));
    }

}