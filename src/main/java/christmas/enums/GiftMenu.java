package christmas.enums;

public enum GiftMenu {
    GIFT_MENU("샴페인 1개",25000),
    NONE("없음",0);
    private final String giftMenu;
    private final int giftMenuMoney;

    GiftMenu(String giftMenu, int giftMenuMoney) {
        this.giftMenu = giftMenu;
        this.giftMenuMoney = giftMenuMoney;
    }

    public String getGiftMenu() {
        return giftMenu;
    }

    public int getGiftMenuMoney() {
        return giftMenuMoney;
    }

}
