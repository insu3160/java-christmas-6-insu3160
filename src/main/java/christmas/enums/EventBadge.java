package christmas.enums;

public enum EventBadge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String description;
    private final int threshold;

    EventBadge(String description, int threshold) {
        this.description = description;
        this.threshold = threshold;
    }

    public String getDescription() {
        return description;
    }

    public static EventBadge calculateEventBadge(int totalDiscount) {
        int absoluteDiscount = Math.abs(totalDiscount);
        for (EventBadge badge : EventBadge.values()) {
            if (absoluteDiscount >= badge.threshold) {
                return badge;
            }
        }
        return EventBadge.NONE;
    }

}
