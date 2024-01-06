public enum Status {
    OUT_FOR_PRICING(3),
    REVISE_AND_RESUBMIT(2),
    UNDER_REVIEW(1),
    AWAITING_APPROVAL(1),
    CLOSED(2),
    FINAL_ESTIMATE(2),
    ROUGH_ESTIMATE(1);

    private final int priority;

    Status(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
