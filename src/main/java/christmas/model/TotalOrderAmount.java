package christmas.model;

import christmas.service.dto.TotalOrderAmountDto;

public class TotalOrderAmount {
    private final int totalOrderAmount;
    private final static int MIN_ORDER_AMOUNT_FOR_EVENT = 10000;

    public TotalOrderAmount(int totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public TotalOrderAmountDto convertToTotalOrderAmountDto() {
        return new TotalOrderAmountDto(totalOrderAmount);
    }

    public boolean canParticipateInEvent() {
        return this.totalOrderAmount >= MIN_ORDER_AMOUNT_FOR_EVENT;
    }

}
