public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int numberOfDistance;

    @Override
    public void drive() { numberOfDistance += 20; }

    public int getDistanceTravelled() { return numberOfDistance; }

}
