package christmas.model;

import christmas.enums.Event;
import christmas.enums.GiftMenu;
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

}
