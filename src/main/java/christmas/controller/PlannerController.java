package christmas.controller;

import christmas.model.VisitDate;
import christmas.service.PlannerService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PlannerController {
    private final PlannerService plannerService;

    public PlannerController() {
        this.plannerService = new PlannerService();
    }

    public void run() {
        VisitDate visitDate = initVisitDate();
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
