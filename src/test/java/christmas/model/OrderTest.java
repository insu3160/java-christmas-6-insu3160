package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.enums.Category;
import christmas.enums.Menu;
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
    void testMatchedCategory(){
        Menu menu = Menu.CHAMPAGNE;
        MenuQuantity firstQuantity = new MenuQuantity(3);
        Order firstOrder = new Order(menu, firstQuantity);

        assertThat(firstOrder.matchedCategory(Category.BEVERAGE)).isTrue();
    }

}