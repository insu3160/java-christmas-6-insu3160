package christmas.enums;

import christmas.contants.ErrorMessages;
import java.util.Arrays;

public enum Menu {
    YANGSONG_SOUP("양송이수프", 6000, Category.APPETIZER),
    TAPAS("타파스", 5500, Category.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER),

    T_BONE_STEAK("티본스테이크", 55000, Category.MAIN),
    BBQ_RIBS("바비큐립", 54000, Category.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, Category.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, Category.MAIN),

    CHOCO_CAKE("초코케이크", 15000, Category.DESSERT),
    ICE_CREAM("아이스크림", 5000, Category.DESSERT),

    ZERO_COLA("제로콜라", 3000, Category.BEVERAGE),
    RED_WINE("레드와인", 60000, Category.BEVERAGE),
    CHAMPAGNE("샴페인", 25000, Category.BEVERAGE);


    private final String menuName;
    private final int price;
    private final Category category;

    Menu(String menuName, int price, Category category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }

    public static Menu findMenu(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE));
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

}
