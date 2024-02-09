import static java.util.Arrays.stream;

class ResistorColorTrio {
    private static final String OHMS = "ohms";
    private static final String KILOOHMS = "kiloohms";
    private static final String MEGAOHMS = "megaohms";
    private static final String GIGAOHMS = "gigaohms";
    private static final String BLAK_SPACE = " ";
    private static final int THOUSAND = 1_000;
    private static final int MILLION = 1_000_000;
    private static final int BILLION = 1_000_000_000;

    public String label(String[] colors) {
        int resistorValueOne = ResistorValue.getValueFromColor(colors[0]);
        int resistorValueTwo = ResistorValue.getValueFromColor(colors[1]);
        int powerOfTen = ResistorValue.getValueFromColor(colors[2]);

        long total = calculateTotal(resistorValueOne, resistorValueTwo, powerOfTen);

        return formatTotal(total);
    }

    private long calculateTotal(int resistorValueOne, int resistorValueTwo, int powerOfTen) {
        return (long) ((resistorValueOne * 10L + resistorValueTwo) * Math.pow(10, powerOfTen));
    }

    private String formatTotal(long total) {
        if (total >= BILLION) {
            return (total / BILLION) + BLAK_SPACE + GIGAOHMS;
        }
        if (total >= MILLION) {
            return (total / MILLION) + BLAK_SPACE + MEGAOHMS;
        }
        if (total >= THOUSAND) {
            return (total / THOUSAND) + BLAK_SPACE + KILOOHMS;
        }
        return total + BLAK_SPACE + OHMS;
    }

    private enum ResistorValue {
        BLACK(0, "black"),
        BROWN(1, "brown"),
        RED(2, "red"),
        ORANGE(3, "orange"),
        YELLOW(4, "yellow"),
        GREEN(5, "green"),
        BLUE(6, "blue"),
        VIOLET(7, "violet"),
        GREY(8, "grey"),
        WHITE(9, "white");

        private final int value;
        private final String color;

        ResistorValue(int value, String color) {
            this.value = value;
            this.color = color;
        }

        public static int getValueFromColor(String color) {
            return stream(ResistorValue.values())
                    .filter(c -> color.equalsIgnoreCase(c.color))
                    .findFirst()
                    .map(c -> c.value)
                    .orElseThrow(() -> new RuntimeException("Invalid"));
        }

    }

}
