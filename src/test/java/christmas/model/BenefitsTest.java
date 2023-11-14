package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.enums.Event;
import christmas.enums.GiftMenu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitsTest {
    @Test
    @DisplayName("증정 이벤트가 존재할 때 증정 메뉴를 잘 반환하는지 확인한다.")
    void testGetGiftMenuWithMatchingEvent(){
        Benefits benefits = new Benefits();
        Benefit giftBenefit = new Benefit(Event.GIFT, -2023);
        benefits.add(giftBenefit);

        GiftMenu result = benefits.getGiftMenu();

        assertThat(result).isEqualTo(GiftMenu.GIFT_MENU);
    }
    @Test
    @DisplayName("증정 이벤트가 존재하지 않을 때 증정 메뉴를 잘 반환하는지 확인한다.")
    void testGetGiftMenuWithOutMatchingEvent(){
        Benefits benefits = new Benefits();
        Benefit giftBenefit = new Benefit(Event.WEEKDAY, -2023);
        benefits.add(giftBenefit);

        GiftMenu result = benefits.getGiftMenu();

        assertThat(result).isEqualTo(GiftMenu.NONE);
    }

}