package christmas.utils;

import christmas.contants.ErrorMessages;

public class Converter {
    public static int stringToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR_MESSAGE);
        }
    }

}
