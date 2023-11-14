package christmas.view;

import christmas.enums.Event;
import christmas.enums.GiftMenu;
import christmas.service.dto.BenefitDto;
import christmas.service.dto.OrderDto;
import christmas.service.dto.TotalOrderAmountDto;
import christmas.service.dto.VisitDateDto;
import java.util.List;

public class OutputView {
    private final static String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String EVENT_BENEFITS_DATE_MESSAGE = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n";
    private final static String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String ORDER_FORMAT = "%s %d개";
    private final static String BEFORE_BENEFIT_PRICE = "<할인 전 총주문 금액>";
    private static final String PRICE_FORMAT_WITH_COMMA = "%,d원%n";
    private static final String GIFT_MENU_TITLE = "<증정 메뉴>";
    private static final String BENEFIT_SECTION_TITLE = "<혜택 내역>";
    private static final String DISCOUNT_FORMAT = "%s: %,d원%n";
    private static final String TOTAL_DISCOUNT_SECTION_TITLE = "<총혜택 금액>";
    private static final String FINAL_PAYMENT_AMOUNT_TITLE = "<할인 후 예상 결제 금액>";
    private static final int ZERO_DISCOUNT = 0;

    public static void welcomeEventPlanner() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void displayEventBenefitsPreview(VisitDateDto visitDateDto) {
        int month = visitDateDto.visitDate().getMonthValue();
        int day = visitDateDto.visitDate().getDayOfMonth();
        System.out.println(String.format(EVENT_BENEFITS_DATE_MESSAGE, month, day));
    }

    public static void displayOrders(List<OrderDto> orderDtos) {
        System.out.println(ORDER_MENU_TITLE);
        for (OrderDto orderDto : orderDtos) {
            System.out.println(String.format(ORDER_FORMAT, orderDto.menu().getMenuName(), orderDto.menuQuantity()));
        }
    }

    public static void displayBeforeBenefitAmount(TotalOrderAmountDto totalOrderAmount) {
        printEmptyLine();
        System.out.println(BEFORE_BENEFIT_PRICE);
        System.out.println(String.format(PRICE_FORMAT_WITH_COMMA, totalOrderAmount.totalOrderAmount()));
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    public static void displayGiftMenu(GiftMenu giftMenu) {
        System.out.println(GIFT_MENU_TITLE);
        System.out.println(giftMenu.getGiftMenu());
    }

    public static void displayBenefitDetails(List<BenefitDto> benefitDtos) {
        printEmptyLine();
        System.out.println(BENEFIT_SECTION_TITLE);
        StringBuilder benefitStringBuilder = new StringBuilder();
        for (BenefitDto benefitDto : benefitDtos) {
            if (benefitDto.discount() != ZERO_DISCOUNT) {
                benefitStringBuilder.append(
                        String.format(DISCOUNT_FORMAT, benefitDto.event().getEventName(), benefitDto.discount()));
            }
        }
        if (benefitStringBuilder.isEmpty()) {
            benefitStringBuilder.append(Event.NOTHING.getEventName());
        }
        System.out.println(benefitStringBuilder);
    }

    public static void displayTotalDiscount(int totalDiscount) {
        System.out.println(TOTAL_DISCOUNT_SECTION_TITLE);
        System.out.println(String.format(PRICE_FORMAT_WITH_COMMA, totalDiscount));

    }

    public static void displayFinalPaymentAmount(int finalPaymentAmount) {
        System.out.println(FINAL_PAYMENT_AMOUNT_TITLE);
        System.out.println(String.format(PRICE_FORMAT_WITH_COMMA, finalPaymentAmount));
    }
    
}
