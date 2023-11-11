package christmas.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @Test
    @DisplayName("메뉴판에 메뉴가 존재 할 시 Menu로 반환한다.")
    void returnMenuIfExistsOnMenuBoard() {
        assertThat(Menu.findMenu("양송이수프")).isEqualTo(Menu.YANGSONG_SOUP);
    }
    
}
