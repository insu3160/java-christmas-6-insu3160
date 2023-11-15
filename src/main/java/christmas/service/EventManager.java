package christmas.service;

import christmas.domain.benefit.Benefits;
import christmas.domain.order.Orders;
import christmas.domain.order.TotalOrderAmount;
import christmas.domain.visitdate.VisitDate;
import christmas.enums.GiftMenu;
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

    public int calculateFinalPaymentAmount(int totalDiscount, GiftMenu giftMenu) {
        return totalOrderAmount.getTotalOrderAmount() + totalDiscount + giftMenu.getGiftMenuMoney();
    }

}
