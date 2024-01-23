import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private final Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        return PLANET_CLASSES[this.random.nextInt(10)];
    }

    String randomShipRegistryNumber() {
        return "NCC-" + this.random.nextInt(1_000, 10_000);
    }

    double randomStardate() {
        return this.random.nextDouble(41_000.0, 42_000.0);
    }
}
