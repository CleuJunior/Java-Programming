class NeedForSpeed {
    private int distancePerOnce ;
    private int batteryDrain;
    private int battery;
    private int distance;



    public NeedForSpeed(int distancePerOnce, int batteryDrain){
        this.distancePerOnce = distancePerOnce;
        this.batteryDrain = batteryDrain;
        this.battery = 100;
    }

    public int getDistancePerOnce() { return distancePerOnce; }

    public int getBatteryDrain() { return batteryDrain; }

    public boolean batteryDrained() { return this.battery == 0; }

    public int distanceDriven() { return this.distance; }

    public void drive() {
        if(!this.batteryDrained()){
            this.distance = this.distance + this.distancePerOnce;
            this.battery = this.battery - this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() { return new NeedForSpeed(50,4);  }
}

class RaceTrack {
    private int trackSize;

    public RaceTrack(int trackSize) {  this.trackSize = trackSize; }

    public boolean carCanFinish(NeedForSpeed car) {
        int neededRace =(int) Math.ceil ((double) this.trackSize / (double) car.getDistancePerOnce()) ;
        return car.getBatteryDrain() * neededRace <= 100;
    }
}
