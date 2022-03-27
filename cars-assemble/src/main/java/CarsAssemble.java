public class CarsAssemble {
    public static final int ITEMSPERHOURS = 221;
    private final int ITEMSPERMINUTS =  (ITEMSPERHOURS/60);

    private double getValuePerHours(int speed, double percentMult) { return ITEMSPERHOURS * speed * percentMult; }
    private int getValuePerMinutesPlus(int speed, int plusValue) { return ITEMSPERMINUTS * speed + plusValue; }
    private int getValuesPerMinutesMinus(int speed, int minusValue) { return ITEMSPERMINUTS * speed - minusValue; }
    public double productionRatePerHour(int speed) {
        if(speed == 0) return 0;
        if(speed == 1) return ITEMSPERHOURS;

        return  speed >= 2 && speed <= 4 ?
                getValuePerHours(speed, 1.0) :
                speed >= 5 && speed <= 8 ?
                getValuePerHours(speed, 0.9) :
                speed == 9 ?
                getValuePerHours(speed, 0.8) :
                getValuePerHours(speed, 0.77);
    }

    public int workingItemsPerMinute(int speed) {
        if(speed == 0) return 0;
        if(speed == 1) return ITEMSPERMINUTS;

        return  speed >= 2 && speed <= 4 ?
                getValuePerMinutesPlus(speed, 0) :
                speed >= 5 && speed <= 7 ?
                getValuePerMinutesPlus(speed,1) :
                speed == 8 ?
                getValuePerMinutesPlus(speed,2) :
                speed == 9 ?
                getValuesPerMinutesMinus(speed, 1) :
                getValuesPerMinutesMinus(speed, 2);
    }




}
