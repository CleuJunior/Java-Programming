class ProductionRemoteControlCar implements RemoteControlCar, Comparable {

    private int numberOfDistance;
    private int numberOfVictories;

    @Override
    public void drive() { numberOfDistance += 10; }
    public int getNumberOfVictories() { return numberOfVictories; }
    public int getDistanceTravelled() { return numberOfDistance; }
    public void setNumberOfVictories(int numberOfVictories) { this.numberOfVictories = numberOfVictories; }

    @Override
    public int compareTo(Object o) { return 0; }
}