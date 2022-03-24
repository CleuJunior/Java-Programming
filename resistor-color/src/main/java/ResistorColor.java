import java.util.HashMap;
import java.util.Map;

class ResistorColor {

    private final Map<String, Integer> resistorColorsValue = new HashMap<>();


    ResistorColor() {
        resistorColorsValue.put("black", 0);
        resistorColorsValue.put("brown", 1);
        resistorColorsValue.put("red", 2);
        resistorColorsValue.put("orange", 3);
        resistorColorsValue.put("yellow", 4);
        resistorColorsValue.put("green", 5);
        resistorColorsValue.put("blue", 6);
        resistorColorsValue.put("violet", 7);
        resistorColorsValue.put("grey", 8);
        resistorColorsValue.put("white", 9);
    }

    int colorCode(String color) { return resistorColorsValue.get(color); }

    String[] colors() {
        return new String[] {
                "black",
                "brown",
                "red",
                "orange",
                "yellow",
                "green",
                "blue",
                "violet",
                "grey",
                "white"
        };
    }
}
