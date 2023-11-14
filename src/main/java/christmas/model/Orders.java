package christmas.model;

import christmas.contants.ErrorMessages;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final static int MENU_QUANTITY_LIMIT = 20;
    private List<Order> orders = new ArrayList<>();

    public void record(Order order) {
        validate(order);
        orders.add(order);
    }

    private void validate(Order order) {
        checkForDuplicates(order);
    }

    private void checkForDuplicates(Order order) {
        if (orders.contains(order)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
        }
    }

    public boolean isOverMenuQuantityLimit() {
        return orders.stream()
                .mapToInt(Order::getMenuQuantity)
                .sum() > MENU_QUANTITY_LIMIT;
    }

}
