package org.enums;

public enum Priority {
    HIGH("HIGH"),
    MEDIUM("MEDIUM"),
    LOW("LOW");

    private final String PriorityName;

    Priority(String PriorityName) {
        this.PriorityName = PriorityName;
    }

    public String getPriorityName() {
        return PriorityName;
    }

    @Override
    public String toString() {
        return PriorityName;
    }
}
