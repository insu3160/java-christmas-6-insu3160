package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.service.dto.TotalOrderAmountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalOrderAmountTest {
    @Test
    @DisplayName("TotalOrderAmountDto로 잘 반환하는지 확인한다.")
    void testConvertToTotalOrderAmountDto(){
        TotalOrderAmount totalOrderAmount = new TotalOrderAmount(15000);
        TotalOrderAmountDto totalOrderAmountDto = totalOrderAmount.convertToTotalOrderAmountDto();

        assertThat(totalOrderAmountDto.totalOrderAmount()).isEqualTo(15000);
    }
    @Test
    @DisplayName("이벤트에 참여할 수 있는 금액이면 true를 반환한다.")
    void testCanParticipateInEvent(){
        TotalOrderAmount cantParticipateEvent = new TotalOrderAmount(8000);
        TotalOrderAmount canParticipateEvent = new TotalOrderAmount(12000);

        assertThat(cantParticipateEvent.canParticipateInEvent()).isFalse();
        assertThat(canParticipateEvent.canParticipateInEvent()).isTrue();
    }

}