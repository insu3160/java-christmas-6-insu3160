package christmas.controller;

import christmas.model.OrderTotalAmount;
import christmas.model.Orders;
import christmas.model.VisitDate;
import christmas.service.OrderManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private final OrderManager orderManager;

    public PlannerController() {
        this.orderManager = new OrderManager();
    }

    public void run() {
        VisitDate visitDate = initVisitDate();
        Orders orders = initOrders();
        OutputView.displayEventBenefitsPreview(visitDate.convertToVisitDateDto());
        OutputView.displayOrders(orders.convertToOrdersDto());
        OrderTotalAmount orderTotalAmount = orderManager.calculateTotalAmount(orders);
    }

    private Orders initOrders() {
        while (true) {
            try {
                return orderManager.recordOrders(InputView.inputOrders());
            } catch (IllegalArgumentException invalidVisitDate) {
                OutputView.printError(invalidVisitDate.getMessage());
            }
        }
    }

    private VisitDate initVisitDate() {
        while (true) {
            try {
                return new VisitDate(InputView.inputVisitDay());
            } catch (IllegalArgumentException invalidVisitDate) {
                OutputView.printError(invalidVisitDate.getMessage());
            }
        }
    }

}
