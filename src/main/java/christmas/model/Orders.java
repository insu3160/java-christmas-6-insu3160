package christmas.model;

import christmas.contants.ErrorMessages;
import java.util.ArrayList;
import java.util.List;

public class Orders {
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

}
