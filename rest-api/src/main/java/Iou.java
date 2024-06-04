/**
 * POJO representing an IOU.
 * <p>
 * If this is in a user's "owed", then the user owes the person with {@link name} this {@link amount}.
 * If this is in a user's "owedBy", then {@link name} owes the user this {@link amount}.
 */
public record Iou(String name, double amount) {
}
