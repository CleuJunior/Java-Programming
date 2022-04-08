import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Robot {

    private static String robotName;
    private static final List<String> robotSet = new ArrayList<>();

    public Robot() { robotName = setName(); }

    private static String setName() {
        return (char) new Random().nextInt(65, 90) + "" +
               (char) new Random().nextInt(65, 90) + "" +
                new Random().nextInt(100, 999);
    }


    public static String getName() {
        while(robotSet.contains(robotName)) { reset(); }
        robotSet.add(robotName);
        return robotName;
    }

    public static void reset() { robotName = setName(); }
}
