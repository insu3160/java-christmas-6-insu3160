package christmas.view;

import christmas.service.dto.OrderDto;
import christmas.service.dto.VisitDateDto;
import java.util.List;

public class OutputView {
    private final static String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String EVENT_BENEFITS_DATE_MESSAGE = "%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private final static String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String ORDER_FORMAT = "%s %d개";

    public static void welcomeEventPlanner() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
    public static void displayEventBenefitsPreview(VisitDateDto visitDateDto) {
        int month = visitDateDto.visitDateDto().getMonthValue();
        int day = visitDateDto.visitDateDto().getDayOfMonth();
        System.out.println(String.format(EVENT_BENEFITS_DATE_MESSAGE, month, day));
    }
    public static void displayOrders(List<OrderDto> orderDtos) {
        System.out.println(ORDER_MENU_TITLE);
        for (OrderDto orderDto : orderDtos) {
            System.out.println(String.format(ORDER_FORMAT,orderDto.menu().getMenuName(),orderDto.menuQuantity()));
        }
    }

}
