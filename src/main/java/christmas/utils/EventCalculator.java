package christmas.utils;

import christmas.enums.Event;
import christmas.model.Benefit;
import christmas.model.Orders;
import christmas.model.VisitDate;

public class EventCalculator {
    private static final int MAX_CHRISTMAS_EVENT_DISCOUNT = -3400;
    private static final int DISCOUNT_INCREASE_AMOUNT = 100;
    private static final int CHRISTMAS_D_DAY_ZERO = 0;
    private static final int DAILY_EVENT_DISCOUNT = -2023;

    public static Benefit calculateChristMasEvent(int Dday) {
        int discount = 0;
        if (Dday >= CHRISTMAS_D_DAY_ZERO) {
            discount = MAX_CHRISTMAS_EVENT_DISCOUNT + Dday * DISCOUNT_INCREASE_AMOUNT;
            return new Benefit(Event.CHRISTMAS, discount);
        }
        return new Benefit(Event.NOTHING, discount);
    }

    public static Benefit calculateDailyEvent(VisitDate visitDate, Orders orders) {
        int discount = 0;
        if (visitDate.isWeekend()) {
            int mainMenuCount = orders.countMainMenu();
            discount = DAILY_EVENT_DISCOUNT * mainMenuCount;
            return new Benefit(Event.WEEKEND, discount);
        }
        int desertMenuCount = orders.countDesertMenu();
        discount = DAILY_EVENT_DISCOUNT * desertMenuCount;
        return new Benefit(Event.WEEKDAY, discount);
    }

}
