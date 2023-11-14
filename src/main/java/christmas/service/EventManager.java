package christmas.service;

import christmas.model.Orders;
import christmas.model.TotalOrderAmount;
import christmas.model.VisitDate;

public class EventManager {
    private final VisitDate visitDate;
    private final Orders orders;
    private final TotalOrderAmount totalOrderAmount;

    public EventManager(VisitDate visitDate, Orders orders, TotalOrderAmount totalOrderAmount) {
        this.visitDate = visitDate;
        this.orders = orders;
        this.totalOrderAmount = totalOrderAmount;
    }

}