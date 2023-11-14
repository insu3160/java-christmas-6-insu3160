package christmas.model;

import christmas.contants.ErrorMessages;

public class MenuQuantity {
    private final static int MIN_MENU_QUANTITY = 1;
    private final int menuQuantity;

    public MenuQuantity(int menuQuantity) {
        validate(menuQuantity);
        this.menuQuantity = menuQuantity;
    }

    private void validate(int menuQuantity) {
        checkMenuQuantity(menuQuantity);
    }

    private void checkMenuQuantity(int menuQuantity) {
        if (menuQuantity < MIN_MENU_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
        }
    }

    public int getMenuQuantity() {
        return menuQuantity;
    }

}
