class Badge {

    private static final char LEFT_SQUARE_BRACKET = '[';
    private static final char RIGHT_SQUARE_BRACKET = ']';
    private static final String HYPHEN = " - ";
    private static final String OWNER = "OWNER";

    public String print(Integer id, String name, String department) {
        StringBuilder completeBadge = new StringBuilder();

        if (id != null) {
            completeBadge
                    .append(LEFT_SQUARE_BRACKET)
                    .append(id)
                    .append(RIGHT_SQUARE_BRACKET)
                    .append(HYPHEN);
        }

        completeBadge.append(name).append(HYPHEN);
        String badgeName = this.badgeOwnerOrOthers(department);
        completeBadge.append(badgeName);

        return completeBadge.toString();
    }

    private String badgeOwnerOrOthers(String department) {
        return department != null ? department.toUpperCase() : OWNER;
    }
}
