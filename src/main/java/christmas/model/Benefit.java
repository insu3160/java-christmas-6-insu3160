package christmas.model;

import christmas.enums.Event;

public class Benefit {
    private final Event event;
    private final int discount;

    public Benefit(Event event, int discount) {
        this.event = event;
        this.discount = discount;
    }

    public Event getEvent() {
        return event;
    }

    public int getDiscount() {
        return discount;
    }

}
