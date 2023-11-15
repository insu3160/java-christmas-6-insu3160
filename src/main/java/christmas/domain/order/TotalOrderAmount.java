package christmas.domain.order;

import christmas.service.dto.TotalOrderAmountDto;

public class TotalOrderAmount {
    private static final int MIN_ORDER_AMOUNT_FOR_EVENT = 10000;
    private static final int MIN_ORDER_AMOUNT_FOR_CHAMPAGNE = 120000;
    private final int totalOrderAmount;

    public TotalOrderAmount(int totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public TotalOrderAmountDto convertToTotalOrderAmountDto() {
        return new TotalOrderAmountDto(totalOrderAmount);
    }

    public boolean canParticipateInEvent() {
        return totalOrderAmount >= MIN_ORDER_AMOUNT_FOR_EVENT;
    }

    public boolean canGetGiftMenu() {
        return totalOrderAmount >= MIN_ORDER_AMOUNT_FOR_CHAMPAGNE;
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

}
