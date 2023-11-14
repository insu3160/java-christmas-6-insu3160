package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.contants.ErrorMessages;
import christmas.enums.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
    @Test
    @DisplayName("중복된 메뉴가 추가 될 시 예외 처리한다.")
    void testRecordDuplicateOrder(){
        Orders orders = new Orders();
        Order firstOrder = new Order(Menu.BBQ_RIBS,new MenuQuantity(2));
        Order secondOrder = new Order(Menu.BBQ_RIBS,new MenuQuantity(1));
        orders.record(firstOrder);

        assertThatThrownBy(() -> orders.record(secondOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }
    @Test
    @DisplayName("총 메뉴 갯수가 20개 초과이면 true를 반환한다.")
    void testIsOverMenuQuantityLimit(){
        Orders orders = new Orders();
        Order firstOrder = new Order(Menu.BBQ_RIBS,new MenuQuantity(15));
        Order secondOrder = new Order(Menu.RED_WINE,new MenuQuantity(6));
        orders.record(firstOrder);
        orders.record(secondOrder);

        assertThat(orders.isOverMenuQuantityLimit()).isTrue();
    }
    @Test
    @DisplayName("음료만 있으면 true를 반환한다.")
    void testHasOnlyBeverages(){
        Orders orders = new Orders();
        Order firstOrder = new Order(Menu.RED_WINE,new MenuQuantity(3));
        Order secondOrder = new Order(Menu.ZERO_COLA,new MenuQuantity(2));
        orders.record(firstOrder);
        orders.record(secondOrder);

        assertThat(orders.hasOnlyBeverages()).isTrue();
    }

}
