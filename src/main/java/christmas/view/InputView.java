package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.contants.ErrorMessages;

public class InputView {
    private static final String INPUT_VISIT_DAY_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public static int inputVisitDay() {
        System.out.println(INPUT_VISIT_DAY_MESSAGE);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DATE_ERROR_MESSAGE);
        }
    }

}
