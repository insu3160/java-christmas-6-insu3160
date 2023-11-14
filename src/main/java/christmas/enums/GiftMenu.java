package christmas.enums;

public enum GiftMenu {
    GIFT_MENU("샴페인 1개"),
    NONE("없음");
    private final String giftMenu;

    GiftMenu(String giftMenu) {
        this.giftMenu = giftMenu;
    }

    public String getGiftMenu() {
        return giftMenu;
    }
    
}
