package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.contants.ErrorMessages;

public class InputView {
    private static final String INPUT_VISIT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String ORDER_SEPARATOR = ",";

    public static int inputVisitDay() {
        System.out.println(INPUT_VISIT_DAY_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DATE_ERROR_MESSAGE);
        }
    }

    public static String[] inputOrders() {
        System.out.println(INPUT_ORDER_MESSAGE);
        return Console.readLine().trim().split(ORDER_SEPARATOR);
    }

}
