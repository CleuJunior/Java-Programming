public class ElonsToyCar {

    private int driven = 0;
    private int percentBattery = 100;

    public static ElonsToyCar buy() { return new ElonsToyCar(); }

    public String distanceDisplay() { return percentBattery > 0 ? "Driven " + driven + " meters" : "Driven " + (driven-20) + " meters";  }

    public String batteryDisplay() { return percentBattery > 0 ? "Battery at " + percentBattery + "%" : "Battery empty";  }

    public void drive() {
        driven+=20;
        percentBattery-=1;
    }
}
