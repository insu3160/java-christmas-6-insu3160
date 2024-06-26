package christmas.controller;

import christmas.domain.benefit.Benefits;
import christmas.domain.order.Orders;
import christmas.domain.order.TotalOrderAmount;
import christmas.domain.visitdate.VisitDate;
import christmas.enums.EventBadge;
import christmas.service.EventManager;
import christmas.service.OrderManager;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private final OrderManager orderManager;

    public PlannerController() {
        this.orderManager = new OrderManager();
    }

    public void run() {
        OutputView.welcomeEventPlanner();
        EventManager eventManager = initEventManager();
        Benefits benefits = eventManager.calculateBenefits();
        displayBenefitPlanner(benefits);
        displayPaymentAmount(eventManager, benefits);
    }

    private void displayPaymentAmount(EventManager eventManager, Benefits benefits) {
        int totalDiscount = benefits.calculateTotalDiscount();
        OutputView.displayTotalDiscount(totalDiscount);

        OutputView.displayFinalPaymentAmount(
                eventManager.calculateFinalPaymentAmount(totalDiscount, benefits.getGiftMenu()));

        OutputView.displayDecemberEventBadge(EventBadge.calculateEventBadge(totalDiscount));
    }

    private void displayBenefitPlanner(Benefits benefits) {
        OutputView.displayGiftMenu(benefits.getGiftMenu());
        OutputView.displayBenefitDetails(benefits.convertToBenefitDtos());
    }

    private EventManager initEventManager() {
        VisitDate visitDate = initVisitDate();
        Orders orders = initOrders();
        OutputView.displayEventBenefitsPreview(visitDate.convertToVisitDateDto());
        OutputView.displayOrders(orders.convertToOrderDtos());

        TotalOrderAmount totalOrderAmount = orderManager.calculateTotalAmount(orders);
        OutputView.displayBeforeBenefitAmount(totalOrderAmount.convertToTotalOrderAmountDto());

        return new EventManager(visitDate, orders, totalOrderAmount);
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
