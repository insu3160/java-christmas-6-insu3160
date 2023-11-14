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

}