package christmas.service.dto;

import christmas.enums.Event;

public record BenefitDto(Event event, int discount) {
}
