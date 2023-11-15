package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.enums.Event;
import christmas.enums.GiftMenu;
import christmas.service.dto.BenefitDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitsTest {
    @Test
    @DisplayName("증정 이벤트가 존재할 때 증정 메뉴를 잘 반환하는지 확인한다.")
    void testGetGiftMenuWithMatchingEvent() {
        Benefits benefits = new Benefits();
        Benefit giftBenefit = new Benefit(Event.GIFT, -2023);
        benefits.add(giftBenefit);

        GiftMenu result = benefits.getGiftMenu();

        assertThat(result).isEqualTo(GiftMenu.GIFT_MENU);
    }

    @Test
    @DisplayName("증정 이벤트가 존재하지 않을 때 증정 메뉴를 잘 반환하는지 확인한다.")
    void testGetGiftMenuWithOutMatchingEvent() {
        Benefits benefits = new Benefits();
        Benefit weekDayBenefit = new Benefit(Event.WEEKDAY, -2023);
        benefits.add(weekDayBenefit);

        GiftMenu result = benefits.getGiftMenu();

        assertThat(result).isEqualTo(GiftMenu.NONE);
    }

    @Test
    @DisplayName("BenefitDto리스트를 잘 반환하는지 확인한다.")
    void testConvertToBenefitDtos() {
        Benefits benefits = new Benefits();

        Benefit giftBenefit = new Benefit(Event.GIFT, -2023);
        Benefit weekDayBenefit = new Benefit(Event.WEEKDAY, -2023);

        benefits.add(giftBenefit);
        benefits.add(weekDayBenefit);

        List<BenefitDto> benefitDtos = benefits.convertToBenefitDtos();

        assertThat(benefitDtos.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("총 혜택 금액을 올바르게 반환하는지 확인한다.")
    void testCalculateTotalDiscount() {
        Benefits benefits = new Benefits();

        Benefit giftBenefit = new Benefit(Event.GIFT, -2023);
        Benefit weekDayBenefit = new Benefit(Event.WEEKDAY, -2023);

        benefits.add(giftBenefit);
        benefits.add(weekDayBenefit);

        assertThat(benefits.calculateTotalDiscount()).isEqualTo(-4046);
    }

}
