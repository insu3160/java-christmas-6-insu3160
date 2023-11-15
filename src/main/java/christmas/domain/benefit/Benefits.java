package christmas.domain.benefit;

import christmas.enums.Event;
import christmas.enums.GiftMenu;
import christmas.service.dto.BenefitDto;
import java.util.ArrayList;
import java.util.List;

public class Benefits {
    private final List<Benefit> benefits;

    public Benefits() {
        this.benefits = new ArrayList<>();
    }

    public void add(Benefit benefit) {
        this.benefits.add(benefit);
    }

    public GiftMenu getGiftMenu() {
        if (benefits.stream()
                .anyMatch(benefit -> benefit.matchedEvent(Event.GIFT))) {
            return GiftMenu.GIFT_MENU;
        }
        return GiftMenu.NONE;
    }

    public List<BenefitDto> convertToBenefitDtos() {
        List<BenefitDto> benefitDtos = new ArrayList<>();
        for (Benefit benefit : benefits) {
            BenefitDto benefitDto = benefit.convertToBenefitDto();
            benefitDtos.add(benefitDto);
        }
        return benefitDtos;
    }

    public int calculateTotalDiscount() {
        return benefits.stream()
                .mapToInt(Benefit::getDiscount)
                .sum();
    }

}
