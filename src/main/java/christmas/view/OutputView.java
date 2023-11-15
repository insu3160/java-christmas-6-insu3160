package christmas.view;

import christmas.enums.Event;
import christmas.enums.EventBadge;
import christmas.enums.GiftMenu;
import christmas.service.dto.BenefitDto;
import christmas.service.dto.OrderDto;
import christmas.service.dto.TotalOrderAmountDto;
import christmas.service.dto.VisitDateDto;
import java.util.List;

public class OutputView {
    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String EVENT_BENEFITS_DATE_MESSAGE = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n";
    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String ORDER_FORMAT = "%s %d개%n";
    private static final String BEFORE_BENEFIT_PRICE = "<할인 전 총주문 금액>";
    private static final String PRICE_FORMAT_WITH_COMMA = "%,d원%n";
    private static final String GIFT_MENU_TITLE = "<증정 메뉴>";
    private static final String BENEFIT_SECTION_TITLE = "<혜택 내역>";
    private static final String DISCOUNT_FORMAT = "%s: %,d원%n";
    private static final String TOTAL_DISCOUNT_SECTION_TITLE = "<총혜택 금액>";
    private static final String FINAL_PAYMENT_AMOUNT_TITLE = "<할인 후 예상 결제 금액>";
    private static final String DECEMBER_EVENT_BADGE_TITLE = "<12월 이벤트 배지>";
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
        StringBuilder orderStringBuilder = new StringBuilder();
        orderDtos.forEach(orderDto -> orderStringBuilder.append(
                String.format(ORDER_FORMAT, orderDto.menu().getMenuName(), orderDto.menuQuantity())));
        System.out.println(orderStringBuilder);
    }

    public static void displayBeforeBenefitAmount(TotalOrderAmountDto totalOrderAmount) {
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

        benefitDtos.stream()
                .filter(benefitDto -> benefitDto.discount() != ZERO_DISCOUNT)
                .forEach(benefitDto -> benefitStringBuilder.append(
                        String.format(DISCOUNT_FORMAT, benefitDto.event().getEventName(), benefitDto.discount())));

        if (benefitStringBuilder.isEmpty()) {
            benefitStringBuilder.append(Event.NOTHING.getEventName()).append("\n");
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

    public static void displayDecemberEventBadge(EventBadge eventBadge) {
        System.out.println(DECEMBER_EVENT_BADGE_TITLE);
        System.out.println(eventBadge.getDescription());
    }

}
