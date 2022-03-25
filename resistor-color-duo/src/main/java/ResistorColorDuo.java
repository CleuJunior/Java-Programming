import java.util.HashMap;
import java.util.Map;

class ResistorColorDuo {


    private final Map<String, String> resistorColorsValue = new HashMap<>();


    ResistorColorDuo() {
        resistorColorsValue.put("black", "0");
        resistorColorsValue.put("brown", "1");
        resistorColorsValue.put("red", "2");
        resistorColorsValue.put("orange", "3");
        resistorColorsValue.put("yellow", "4");
        resistorColorsValue.put("green", "5");
        resistorColorsValue.put("blue", "6");
        resistorColorsValue.put("violet", "7");
        resistorColorsValue.put("grey", "8");
        resistorColorsValue.put("white", "9");
    }
    int value(String[] colors) {
        return Integer.parseInt(resistorColorsValue.get(colors[0]) + resistorColorsValue.get(colors[1]));
    }
}
