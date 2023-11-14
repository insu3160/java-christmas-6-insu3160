package christmas.enums;

public enum Event {
    CHRISTMAS("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL("특별 할인"),
    GIFT("증정 이벤트"),
    NOTHING("없음");

    private final String eventName;

    Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

}
