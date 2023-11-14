package christmas.model;

import christmas.enums.Menu;

public class Order {
    private final Menu menu;
    private final MenuQuantity menuQuantity;

    public Order(Menu menu, MenuQuantity menuQuantity) {
        this.menu = menu;
        this.menuQuantity = menuQuantity;
    }

}
