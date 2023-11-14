package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.enums.Event;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {
    @Test
    @DisplayName("인자 값으로 전달 받은 Event가 상태로 가진 Event와 같을 시 true 반환한다.")
    void testMatchedEvent(){
        Benefit benefit = new Benefit(Event.GIFT, -2000);

        assertThat(benefit.matchedEvent(Event.GIFT)).isTrue();
        assertThat(benefit.matchedEvent(Event.CHRISTMAS)).isFalse();
    }

}