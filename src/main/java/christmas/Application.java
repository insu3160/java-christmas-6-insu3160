package christmas;

import christmas.controller.PlannerController;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.welcomeEventPlanner();
        PlannerController plannerController = new PlannerController();
        plannerController.run();
    }
}
