package christmas.service;

import christmas.contants.ErrorMessages;
import christmas.enums.Menu;
import christmas.model.MenuQuantity;
import christmas.model.Order;
import christmas.model.Orders;
import christmas.utils.Converter;

public class OrderManager {
    private static final String ITEM_SEPARATOR = "-";
    private final static int MENU_NAME_INDEX = 0;
    private final static int MENU_QUANTITY_INDEX = 1;

    public Orders recordOrders(String[] inputOrders) {
        Orders orders = new Orders();
        for (String order : inputOrders) {
            orders.record(createOrder(order.split(ITEM_SEPARATOR)));
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
        Menu menu = Menu.findMenu(order[MENU_NAME_INDEX]);
        MenuQuantity menuQuantity = new MenuQuantity(Converter.stringToInt(order[MENU_QUANTITY_INDEX]));
        return new Order(menu, menuQuantity);
    }

}

