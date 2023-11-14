package christmas.model;

import christmas.service.dto.TotalOrderAmountDto;

public class TotalOrderAmount {
    private final int totalOrderAmount;

    public TotalOrderAmount(int totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public TotalOrderAmountDto convertToTotalOrderAmountDto() {
        return new TotalOrderAmountDto(totalOrderAmount);
    }

}
