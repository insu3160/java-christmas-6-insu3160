package christmas.domain.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.contants.ErrorMessages;
import christmas.enums.Menu;
import christmas.service.dto.OrderDto;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
    private Orders orders;

    @BeforeEach
    void setUp() {
        orders = new Orders();
    }

    @Test
    @DisplayName("중복된 메뉴가 추가 될 시 예외 처리한다.")
    void testRecordDuplicateOrder() {
        recordOrder(Menu.BBQ_RIBS, 2);

        assertThatThrownBy(() -> recordOrder(Menu.BBQ_RIBS, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("총 메뉴 갯수가 20개 초과이면 true를 반환한다.")
    void testIsOverMenuQuantityLimit() {
        recordOrder(Menu.BBQ_RIBS, 15);
        recordOrder(Menu.RED_WINE, 6);

        assertThat(orders.isOverMenuQuantityLimit()).isTrue();
    }

    @Test
    @DisplayName("음료만 있으면 true를 반환한다.")
    void testHasOnlyBeveragesWhenOnlyBeveragesExist() {
        recordOrder(Menu.RED_WINE, 2);
        recordOrder(Menu.ZERO_COLA, 2);

        assertThat(orders.hasOnlyBeverages()).isTrue();
    }

    @Test
    @DisplayName("음료가 아닌 다른 음식이 있다면 false를 반환한다.")
    void testHasOnlyBeveragesWhenNonBeverageExists() {
        recordOrder(Menu.T_BONE_STEAK, 2);
        recordOrder(Menu.ZERO_COLA, 2);

        assertThat(orders.hasOnlyBeverages()).isFalse();
    }

    @Test
    @DisplayName("OrderDto리스트를 잘 반환하는지 확인한다.")
    void testConvertToOrderDtos() {
        recordOrder(Menu.RED_WINE, 15);
        recordOrder(Menu.ZERO_COLA, 2);

        List<OrderDto> orderDtos = orders.convertToOrderDtos();

        assertThat(orderDtos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("주문에 대한 총 가격을 잘 반환하는지 확인한다.")
    void testCalculateTotalAmount() {
        recordOrder(Menu.CAESAR_SALAD, 3);
        recordOrder(Menu.ZERO_COLA, 2);

        int totalAmount = Menu.CAESAR_SALAD.getPrice() * 3 + Menu.ZERO_COLA.getPrice() * 2;

        assertThat(orders.caclulateTotalAmount()).isEqualTo(totalAmount);
    }

    @Test
    @DisplayName("메인 메뉴의 갯수를 잘 반환하는지 확인한다.")
    void testCountMainMenu() {
        recordOrder(Menu.T_BONE_STEAK, 3);
        recordOrder(Menu.ZERO_COLA, 2);
        recordOrder(Menu.BBQ_RIBS, 2);

        assertThat(orders.countMainMenu()).isEqualTo(5);
    }

    @Test
    @DisplayName("디저트 메뉴의 갯수를 잘 반환하는지 확인한다.")
    void testCountDesertMenu() {
        recordOrder(Menu.CHOCO_CAKE, 2);
        recordOrder(Menu.ICE_CREAM, 2);
        recordOrder(Menu.BBQ_RIBS, 2);

        assertThat(orders.countDesertMenu()).isEqualTo(4);
    }

    private Order recordOrder(Menu menu, int quantity) {
        Order order = new Order(menu, new MenuQuantity(quantity));
        orders.record(order);
        return order;
    }

}
