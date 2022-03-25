
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() { return new int[] {0, 2, 5, 3, 7, 8, 4}; }

    public int getToday() { return birdsPerDay.length == 0 ? 0 : birdsPerDay[birdsPerDay.length - 1]; }

    public void incrementTodaysCount() { birdsPerDay[birdsPerDay.length - 1] +=1; }

    public boolean hasDayWithoutBirds() {
        for(int checkZero: birdsPerDay) { if(checkZero == 0) return true; }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        if(numberOfDays > 7) numberOfDays = 7;
        int count = 0;

        for (int index = numberOfDays-1; index >= 0; index--) {
            count += birdsPerDay[index];
        }

        return count;
    }

    public int getBusyDays() {
        int busyDaysCount = 0;

        for(int checkForBusyDays: birdsPerDay) {
            if (checkForBusyDays >= 5) { busyDaysCount++; }
        }

        return busyDaysCount;
    }
}
