package christmas.domain.order;

import christmas.contants.ErrorMessages;
import christmas.enums.Category;
import christmas.service.dto.OrderDto;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final static int MENU_QUANTITY_LIMIT = 20;
    private List<Order> orders = new ArrayList<>();

    public void record(Order order) {
        validate(order);
        this.orders.add(order);
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

    public boolean hasOnlyBeverages() {
        return orders.stream().allMatch(order -> order.matchedCategory(Category.BEVERAGE));
    }

    public List<OrderDto> convertToOrderDtos() {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = order.convertToOrderDto();
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    public int caclulateTotalAmount() {
        return orders.stream()
                .mapToInt(Order::caculatePrice)
                .sum();
    }

    public int countMainMenu() {
        return orders.stream()
                .filter(order -> order.matchedCategory(Category.MAIN))
                .mapToInt(Order::getMenuQuantity)
                .sum();
    }

    public int countDesertMenu() {
        return orders.stream()
                .filter(order -> order.matchedCategory(Category.DESSERT))
                .mapToInt(Order::getMenuQuantity)
                .sum();
    }

}
