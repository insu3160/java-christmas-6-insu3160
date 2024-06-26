package christmas.utils;

import christmas.domain.benefit.Benefit;
import christmas.domain.order.Orders;
import christmas.domain.order.TotalOrderAmount;
import christmas.domain.visitdate.VisitDate;
import christmas.enums.Category;
import christmas.enums.Event;
import christmas.enums.GiftMenu;

public class EventCalculator {
    private static final int MAX_CHRISTMAS_EVENT_DISCOUNT = -3400;
    private static final int DISCOUNT_INCREASE_AMOUNT = 100;
    private static final int CHRISTMAS_D_DAY_ZERO = 0;
    private static final int DAILY_EVENT_DISCOUNT = -2023;
    private static final int SPECIAL_EVENT_DISCOUNT = -1000;
    private static final int DISCOUNT_DEFAULT = 0;

    public static Benefit calculateChristMasEvent(int Dday) {
        int discount = DISCOUNT_DEFAULT;
        if (Dday >= CHRISTMAS_D_DAY_ZERO) {
            discount = MAX_CHRISTMAS_EVENT_DISCOUNT + Dday * DISCOUNT_INCREASE_AMOUNT;
            return new Benefit(Event.CHRISTMAS, discount);
        }
        return new Benefit(Event.NOTHING, discount);
    }

    public static Benefit calculateDailyEvent(VisitDate visitDate, Orders orders) {
        int discount = DISCOUNT_DEFAULT;
        if (visitDate.isWeekend()) {
            int mainMenuCount = orders.countMenuCategory(Category.MAIN);
            discount = DAILY_EVENT_DISCOUNT * mainMenuCount;
            return new Benefit(Event.WEEKEND, discount);
        }
        int desertMenuCount = orders.countMenuCategory(Category.DESSERT);
        discount = DAILY_EVENT_DISCOUNT * desertMenuCount;
        return new Benefit(Event.WEEKDAY, discount);
    }

    public static Benefit calculateSpecialEvent(VisitDate visitDate) {
        int discount = DISCOUNT_DEFAULT;
        if (visitDate.isSpecialDay()) {
            discount = SPECIAL_EVENT_DISCOUNT;
            return new Benefit(Event.SPECIAL, discount);
        }
        return new Benefit(Event.NOTHING, discount);
    }

    public static Benefit calculatGiftEvent(TotalOrderAmount totalOrderAmount) {
        int discount = DISCOUNT_DEFAULT;
        if (totalOrderAmount.canGetGiftMenu()) {
            discount = -GiftMenu.GIFT_MENU.getGiftMenuMoney();
            return new Benefit(Event.GIFT, discount);
        }
        return new Benefit(Event.NOTHING, discount);
    }

}
