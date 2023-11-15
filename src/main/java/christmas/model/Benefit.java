package christmas.model;

import christmas.enums.Event;
import christmas.service.dto.BenefitDto;

public class Benefit {
    private final Event event;
    private final int discount;

    public Benefit(Event event, int discount) {
        this.event = event;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public boolean matchedEvent(Event event) {
        return this.event.equals(event);
    }

    public BenefitDto convertToBenefitDto() {
        return new BenefitDto(event, discount);
    }

}
