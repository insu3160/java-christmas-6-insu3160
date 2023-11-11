package christmas.service;

import christmas.model.VisitDate;
import christmas.utils.Converter;

public class PlannerService {
    private VisitDate visitDate;

    public void initVisitDate(String inputVisitDay) {
        this.visitDate = new VisitDate(Converter.stringToInt(inputVisitDay));
    }

}

