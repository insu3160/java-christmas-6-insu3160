package christmas.controller;

import christmas.service.PlannerService;
import christmas.view.InputView;

public class PlannerController {
    private final PlannerService plannerService;

    public PlannerController() {
        this.plannerService = new PlannerService();
    }

    public void run() {
        initVisitDate();
    }

    private void initVisitDate() {
        plannerService.initVisitDate(InputView.inputVisitDay());
    }

}
