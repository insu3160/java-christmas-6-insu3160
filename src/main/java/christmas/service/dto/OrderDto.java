package christmas.service.dto;

import christmas.enums.Menu;

public record OrderDto(Menu menu, int menuQuantity) {
}
