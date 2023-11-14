package christmas.service;

import christmas.model.Benefits;
import christmas.model.Orders;
import christmas.model.TotalOrderAmount;
import christmas.model.VisitDate;
import christmas.utils.EventCalculator;

public class EventManager {
    private final VisitDate visitDate;
    private final Orders orders;
    private final TotalOrderAmount totalOrderAmount;

    public EventManager(VisitDate visitDate, Orders orders, TotalOrderAmount totalOrderAmount) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.totalOrderAmount = totalOrderAmount;
    }

    public Benefits calculateBenefits() {
        Benefits benefits = new Benefits();
        if (totalOrderAmount.canParticipateInEvent()) {
            benefits.add(EventCalculator.calculateChristMasEvent(visitDate.getChristMasDday()));
            benefits.add(EventCalculator.calculateDailyEvent(visitDate, orders));
            benefits.add(EventCalculator.calculateSpecialEvent(visitDate));
            benefits.add(EventCalculator.calculatGiftEvent(totalOrderAmount));
        }
        return benefits;
    }

}
