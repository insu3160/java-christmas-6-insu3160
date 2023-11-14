package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuQuantityTest {
    @Test
    @DisplayName("MenuQuantity가 잘 생성되는지 확인한다.")
    void testValidMenuQuantity() {
        int validQuantity = 3;
        MenuQuantity menuQuantity = new MenuQuantity(3);

        assertThat(menuQuantity.getMenuQuantity()).isEqualTo(validQuantity);
    }

}
