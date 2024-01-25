class SpaceAge {
    private static final int EARTH_SECONDS = 31_557_600;
    private static final double MERCURY_ORBITAL_DIFF =  0.2_408_467;
    private static final double VENUS_ORBITAL_DIFF =  0.61_519_726;
    private static final double MARS_ORBITAL_DIFF =  1.880_815_8;
    private static final double JUPITER_ORBITAL_DIFF =  11.862_615 ;
    private static final double SATURN_ORBITAL_DIFF =  29.447_498;
    private static final double URANUS_ORBITAL_DIFF =  84.016_846;
    private static final double NAPTUNE_ORBITAL_DIFF =  164.791_32;
    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
        return this.seconds / EARTH_SECONDS;
    }

    double onMercury() {
        return this.differenceBetweenEarthAndOtherPlanet(MERCURY_ORBITAL_DIFF);
    }

    double onVenus() {
        return this.differenceBetweenEarthAndOtherPlanet(VENUS_ORBITAL_DIFF);
    }

    double onMars() {
        return this.differenceBetweenEarthAndOtherPlanet(MARS_ORBITAL_DIFF);
    }

    double onJupiter() {
        return this.differenceBetweenEarthAndOtherPlanet(JUPITER_ORBITAL_DIFF);
    }

    double onSaturn() {
        return this.differenceBetweenEarthAndOtherPlanet( SATURN_ORBITAL_DIFF);
    }

    double onUranus() {
        return this.differenceBetweenEarthAndOtherPlanet(URANUS_ORBITAL_DIFF);
    }

    double onNeptune() {
        return this.differenceBetweenEarthAndOtherPlanet( NAPTUNE_ORBITAL_DIFF);
    }

    private double differenceBetweenEarthAndOtherPlanet(double planet) {
        return this.seconds / EARTH_SECONDS / planet;
    }

}
