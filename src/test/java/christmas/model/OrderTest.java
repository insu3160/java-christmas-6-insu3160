package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.enums.Category;
import christmas.enums.Menu;
import christmas.service.dto.OrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    @Test
    @DisplayName("메뉴가 같을 시 같은 객체로 인식하는지 확인한다.")
    void testEqualsOrder() {
        Menu menu = Menu.CHAMPAGNE;
        MenuQuantity firstQuantity = new MenuQuantity(3);
        MenuQuantity secondQuantity = new MenuQuantity(2);
        Order firstOrder = new Order(menu, firstQuantity);
        Order secondOrder = new Order(menu, secondQuantity);

        assertThat(firstOrder.equals(secondOrder)).isTrue();
    }

    @Test
    @DisplayName("넘겨 받은 카테고리가 일치할 때 true를 반환한다.")
    void testMatchedCategory() {
        Menu menu = Menu.CHAMPAGNE;
        MenuQuantity firstQuantity = new MenuQuantity(3);
        Order firstOrder = new Order(menu, firstQuantity);

        assertThat(firstOrder.matchedCategory(Category.BEVERAGE)).isTrue();
    }

    @Test
    @DisplayName("OrderDto를 잘 반환하는지 확인한다.")
    void testConvertToOrderDto() {
        Menu menu = Menu.CHAMPAGNE;
        MenuQuantity firstQuantity = new MenuQuantity(3);
        Order firstOrder = new Order(menu, firstQuantity);

        OrderDto firstOrderDto = firstOrder.convertToOrderDto();

        assertThat(firstOrderDto.menu()).isEqualTo(menu);
        assertThat(firstOrderDto.menuQuantity()).isEqualTo(3);
    }

    @Test
    @DisplayName("메뉴마다의 총가격을 잘 반환하는지 확인한다.")
    void testCalculatePrice() {
        Menu menu = Menu.CHAMPAGNE;
        MenuQuantity firstQuantity = new MenuQuantity(3);
        Order firstOrder = new Order(menu, firstQuantity);

        assertThat(firstOrder.caculatePrice()).isEqualTo(Menu.CHAMPAGNE.getPrice() * firstQuantity.getMenuQuantity());
    }

}
