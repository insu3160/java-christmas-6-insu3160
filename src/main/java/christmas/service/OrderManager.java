package christmas.service;

import christmas.contants.ErrorMessages;
import christmas.domain.order.MenuQuantity;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import christmas.domain.order.TotalOrderAmount;
import christmas.enums.Menu;
import christmas.utils.Converter;

public class OrderManager {
    private static final String NAME_QUANTITY_SEPARATOR = "-";
    private static final int MENU_NAME_INDEX = 0;
    private static final int MENU_QUANTITY_INDEX = 1;
    private static final int ORDER_PARTS = 2;

    public Orders recordOrders(String[] inputOrders) {
        Orders orders = new Orders();
        for (String order : inputOrders) {
            orders.record(createOrder(order.split(NAME_QUANTITY_SEPARATOR)));
        }
        validate(orders);
        return orders;
    }

    private void validate(Orders orders) {
        checkTotalQuantity(orders);
        checkOnlyBeverage(orders);
    }

    private void checkOnlyBeverage(Orders orders) {
        if (orders.hasOnlyBeverages()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
        }
    }

    private void checkTotalQuantity(Orders orders) {
        if (orders.isOverMenuQuantityLimit()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
        }
    }

    private Order createOrder(String[] order) {
        checkMenuFormatValidity(order);
        Menu menu = Menu.findMenu(order[MENU_NAME_INDEX]);
        MenuQuantity menuQuantity = new MenuQuantity(Converter.stringToInt(order[MENU_QUANTITY_INDEX]));
        return new Order(menu, menuQuantity);
    }

    private void checkMenuFormatValidity(String[] order) {
        if (order.length != ORDER_PARTS) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
        }

    }

    public TotalOrderAmount calculateTotalAmount(Orders orders) {
        return new TotalOrderAmount(orders.caclulateTotalAmount());
    }

}

