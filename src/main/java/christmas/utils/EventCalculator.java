package christmas.utils;

import christmas.enums.Event;
import christmas.model.Benefit;

public class EventCalculator {
    private static final int MAX_CHRISTMAS_EVENT_DISCOUNT = -3400;
    private static final int DISCOUNT_INCREASE_AMOUNT = 100;
    private static final int CHRISTMAS_D_DAY_ZERO = 0;

    public static Benefit calculateChristMasEvent(int Dday) {
        int discount = 0;
        if (Dday >= CHRISTMAS_D_DAY_ZERO) {
            discount = MAX_CHRISTMAS_EVENT_DISCOUNT + Dday * DISCOUNT_INCREASE_AMOUNT;
            return new Benefit(Event.CHRISTMAS, discount);
        }
        return new Benefit(Event.NOTHING, discount);
    }

}
