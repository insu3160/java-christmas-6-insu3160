package christmas.model;

import christmas.enums.Category;
import christmas.enums.Menu;
import christmas.service.dto.OrderDto;
import java.util.Objects;

public class Order {
    private final Menu menu;
    private final MenuQuantity menuQuantity;

    public Order(Menu menu, MenuQuantity menuQuantity) {
        this.menu = menu;
        this.menuQuantity = menuQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(menu, order.menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    public int getMenuQuantity() {
        return menuQuantity.getMenuQuantity();
    }

    public boolean matchedCategory(Category category) {
        return this.menu.getCategory().equals(category);
    }

    public OrderDto convertToOrderDto() {
        return new OrderDto(menu, menuQuantity.getMenuQuantity());
    }

}
